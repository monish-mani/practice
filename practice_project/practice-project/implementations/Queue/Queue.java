package Queue;

import LinkedList.ListNode;

public class Queue<T> {
	
	ListNode<T> head;
	ListNode<T> tail;
	int size=0;
	
	/*
	 * Methods
	 * 1. Insert
	 * 2. Remove
	 * 3. Traverse
	 * 4. Size
	 * 5. IsEmpty
	 * 6. peek
	 * 
	 */
	
	public ListNode<T> insert(T t){
		ListNode<T> newValue = new ListNode<T>(t);
		if(head == null){
			head = newValue;
			tail = newValue;
		}else{
			//Insert at the end
			tail.setNext(newValue);
			tail = newValue;
		}
	
		size++;
		return tail;
	}
	
	public ListNode<T> remove(){
		if(size == 0){
			System.out.println("Cannot remove as queue is empty!");
			return null;
		}
		
		ListNode<T> removedValue = head;
		head = head.getNext();
		size--;
		return removedValue;
	}
	
	public boolean isEmpty(){
		return size == 0 ? true : false;
	}
	
	
	public int size(){
		return size;
	}
	
	public void traverse(){
		StringBuilder result = new StringBuilder();
		ListNode<T> temp = head;
		while(temp!=null){
			result.append(temp.getVal());
			result.append("->");
			temp = temp.getNext();
		}
		result.append("X");
		System.out.println("Queue : " + result);
	}
	
	public ListNode<T> peek(){
		return head;
	}

}

