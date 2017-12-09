package LinkedList;

public class LinkedList<T> {
	
	ListNode<T> head;
	ListNode<T> tail;
	int size;
	
	/*
	 * Functions:
	 * 1) Insert head
	 * 2) Insert end
	 * 3) Insert at position
	 * 4) is empty?
	 * 5) traverse
	 * 6) size
	 * 7) contains
	 * 8) Remove at position
	 */
	
	LinkedList(){
		
	}
	
	//Add at the end (Java method : offer)
	public ListNode<T> addEnd(T t){
		if(head == null){
			head = new ListNode<>(t);
			tail = head;
			
		}else{
			ListNode<T> newValue = new ListNode<>(t);
			tail.setNext(newValue);
			tail = newValue;
			
		}
		size++;
		return tail;
	}
	
	
	//Search
	public boolean contains(T t){
		if(head == null){
			System.out.println("List is empty");
			return false;
		}
		
		ListNode<T> temp = head;
		while(temp!=null){
			if(temp.getVal().equals(t)){
				return true;
			}
			temp = temp.getNext();
		}
		
		return false;
	}
	
	//Add first
	public ListNode<T> addFirst(T t){
		if(head == null){
			head = new ListNode<>(t);
			tail = head;
		}else{
			ListNode<T> newValue = new ListNode<>(t);
			newValue.setNext(head);
			head=newValue;
		}
		size++;
		return head;
	}

	
	//Is empty
	public boolean isEmpty(){
		return head ==  null ? true : false;
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
		System.out.println("Linked List : " + result);
	}
	
	
	//Insert at position
	public ListNode<T> insertAtPosition(T t, int position){
		ListNode<T> prev = null;
		ListNode<T> current = head;
		int currentPosition = 1;
		
		//If the position is not valid, return null;
		if(head == null){
			return head;
		}
		
		while(current!=null){
			if(currentPosition == position){
				ListNode<T> newValue = new ListNode<>(t);
				if(prev==null){
					newValue.setNext(head);
					head = newValue;
					
				}else{
					prev.setNext(newValue);
					newValue.setNext(current);
				}
				return newValue;
			}
			prev = current;
			current = current.getNext();
			currentPosition++;
		}
		
		return null;
	}
	
	//Remove at position
	public ListNode<T> removeAtPosition(int position){
		ListNode<T> prev = null;
		ListNode<T> current = head;
		int currentPosition = 1;
		
		//If the position is not valid, return null;
		if(head == null){
			System.out.println("Cannot remove as list is empty");
			return head;
		}
		
		while(current!=null){
			if(currentPosition == position){
				//Removing the head
				if(prev == null){
					head = head.getNext();
					
				}else{
					prev.setNext(current.getNext());
				}
				
				return current;
			}
			
			prev = current;
			current = current.getNext();
			currentPosition++;
		}
		return null;
	}
}
