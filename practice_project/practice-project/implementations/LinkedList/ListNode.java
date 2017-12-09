package LinkedList;

public class ListNode<T> {
	
	private T val;
	private ListNode next;
	
	
	public ListNode(T val){
		this.val = val;
	}
	
	public T getVal(){
		return val;
	}
	
	public ListNode getNext(){
		return next;
	}
	
	
	public void setVal(T t){
		this.val = t;
	}
	
	public void setNext(ListNode next){
		this.next = next;
	}
	

}
