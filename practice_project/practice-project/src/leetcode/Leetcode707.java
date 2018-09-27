package leetcode;

public class Leetcode707 {
	ListNode head;
	ListNode tail;
	int length;
	
	public class ListNode{
		int val;
		ListNode next;
		
		ListNode(int val){
			this.val = val;
		}
	}

	public Leetcode707() {
        head = null;
        length=0;
    }
    
	/** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= length) return -1;
        
        ListNode curr = head;
        
        while(curr!=null && index > 0) {
        	curr = curr.next;
        	index--;
        }
        
        return curr.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
    	if(head == null) {
        	tail = newNode;
        }else {
        	newNode.next = head;
        }
    	head = newNode;
    	length++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        if(tail == null) {
        	head = newNode;
        }else {
        	tail.next = newNode;
        }
        tail = newNode;
        length++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > length) return;
        if(index == 0) {
        	addAtHead(val);
        	return;
        }else if(index == length) {
        	addAtTail(val);
        	return;
        }else {
        	ListNode prev = null;
        	ListNode curr = head;
        	ListNode newNode = new ListNode(val);
        	
        	while(curr!=null && index > 0) {
        		prev = curr;
        		curr = curr.next;
        		index--;
        	}
        	prev.next = newNode;
        	newNode.next = curr;
        	length++;
        }
        
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= length) return;
        
        if(index == 0) {
        	if(head == tail) {
        		tail = tail.next;
        	}
        	head = head.next;
        }else {
        	ListNode prev = null;
        	ListNode curr = head;
        	
        	while(curr!=null && index > 0) {
        		prev = curr;
        		curr = curr.next;
        		index--;
        	}
        	
        	prev.next = curr.next;
        }
        length--;
    }
	
	

}
