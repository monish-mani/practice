package Stack;

import LinkedList.ListNode;

public class Stack<T> {
	
	ListNode<T> top;
	int size=0;
	
	/*
	 * Methods:
	 * 1) push
	 * 2) pop
	 * 3) top
	 * 
	 */
	
	
	ListNode<T> push(T t){
		ListNode<T> newValue = new ListNode<>(t);
		if(top!=null){
			newValue.setNext(top);
		}
		size++;
		top = newValue;
		return top;
	}
	
	ListNode<T> pop(){
		ListNode<T> returnNode = top;
		if(top!=null){
			top = top.getNext();
		}
		size--;
		return returnNode;
	}

	
	ListNode<T> peek(){
		return top;
	}
	
	boolean isEmpty(){
		return size == 0 ? true : false;
	}
	
	
	public void traverse(){
		StringBuilder result = new StringBuilder();
		ListNode<T> temp = top;
		while(temp!=null){
			result.append(temp.getVal());
			result.append("->");
			temp = temp.getNext();
		}
		result.append("X");
		System.out.println("Stack from top to bottom : " + result);
	
		
	}
}
