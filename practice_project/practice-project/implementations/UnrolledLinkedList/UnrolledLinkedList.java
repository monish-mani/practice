package UnrolledLinkedList;

public class UnrolledLinkedList {
	
	int arraySize;
	ULLNode head;
	int numOfNodes;
	ULLNode tail;

	/*
	 * Methods supported:
	 * 1) Search
	 * 2) Add 
	 *
	 */
	
	
	UnrolledLinkedList(int arraySize){
		this.arraySize=arraySize;
		head = new ULLNode(arraySize);
		tail = head;
		numOfNodes=1;
	}
	
	
	public void add(int num){
		boolean alreadyExists = search(num);
		if(alreadyExists){
			System.out.println(num + " already exists in unrolled LL!");
		}

		ULLNode relevantNode = getRelevantNode(head,num);
		ULLNode originalNode;
		if(relevantNode.getArrLastIndex() > (this.arraySize/2) - 1){
			originalNode = shiftHalfElementsToNewULLNode(relevantNode);
			relevantNode = getRelevantNode(originalNode,num);
		}

		addNumberInNode(relevantNode,num);
	}
	
	public boolean search(int num){
		ULLNode relevantNode = getRelevantNode(head,num);
		if(relevantNode == null){
			relevantNode = new ULLNode(this.arraySize);
			tail.setNext(relevantNode);
			tail = relevantNode;
		}
		
		int pos = binarySearchULLNode(relevantNode,num);
		
		return pos >= 0 ? true : false;
	}
	
	
	private ULLNode getRelevantNode(ULLNode head,int num){
		ULLNode tempHead = head;
		while(tempHead!=null){
			int[] numArray = tempHead.getArr();
			if(numArray.length == 0) return tempHead;
			
			if(num >= numArray[0] && num <= numArray[tempHead.getArrLastIndex()]) return tempHead;
			
			tempHead = tempHead.getNext();
		}
		
		return null;
	}
	
	private int binarySearchULLNode(ULLNode relevantNode,int num){
		int[] ULLArray = relevantNode.getArr();
		int start = 0;
		int end = ULLArray.length-1;
		
		while(start <= end){
			int mid = (start + end)/2;
			if(ULLArray[mid] == num){
				return mid;
			}else if(ULLArray[mid] > num){
				end = mid -1;
			}else{
				start = mid + 1;
			}
		}
		
		return -1;
		
	}
	
	private ULLNode shiftHalfElementsToNewULLNode(ULLNode originalNode){
		ULLNode newNode = new ULLNode(arraySize);
		int shiftStartIndex = (arraySize/2) - 1;
		
		//Shift second half into a new ULL node and attach it to the right of the original node
		//Clear shifted positions from the original array
		int[] originalArray = originalNode.getArr();
		int[] newArray = newNode.getArr();
		
		int j=0;
		for(int i=shiftStartIndex;i<=originalNode.getArrLastIndex();i++){
			newArray[j++] = originalArray[shiftStartIndex];
			originalArray[shiftStartIndex]=0;
		}
		
		//Attach new node to the right of original node
		newNode.setNext(originalNode.getNext());
		originalNode.setNext(newNode);
		
		if(tail == originalNode) tail = newNode;
		
		return originalNode;
		
	}
	
	private void addNumberInNode(ULLNode relevantNode,int num){
		int[] arr = relevantNode.getArr();
		
		if(relevantNode.arrLastIndex == 1){
			if(arr[0] > num){
				arr[1] = arr[0];
				arr[0] = num;
			}else{
				arr[1]=num;
			}
		}
		
		for(int i=1;i<=relevantNode.getArrLastIndex();i++){
			if(arr[i-1] > num && num < arr[i]){ //Was able to finish by 40 min!
				shiftNumbersByOne(relevantNode,i);
				arr[i] = num;
				return;
			}
		}
		
	}
	
	private void shiftNumbersByOne(ULLNode relevantNode,int pos){
		int lastIndex = relevantNode.getArrLastIndex();
		int[] arr = relevantNode.getArr();
		
		while(lastIndex >= pos){
			arr[lastIndex+1] = arr[lastIndex];
			lastIndex--;
		}
		
		//Set new lastIndex for the node.
		relevantNode.setArrLastIndex(relevantNode.getArrLastIndex()+1);
	}
	
}
