package UnrolledLinkedList;

public class ULLNode {
	
	private ULLNode next;
	private int[] arr;
	int arrLastIndex;
	
	
	
	public ULLNode(int arrSize){
		arr = new int[arrSize];
		next = null;
		arrLastIndex=0;
	}


	


	public int getArrLastIndex() {
		return arrLastIndex;
	}





	public void setArrLastIndex(int arrLastIndex) {
		this.arrLastIndex = arrLastIndex;
	}





	public ULLNode getNext() {
		return next;
	}



	public void setNext(ULLNode next) {
		this.next = next;
	}



	public int[] getArr() {
		return arr;
	}



	public void setArr(int[] arr) {
		this.arr = arr;
	}
	
	
	

}
