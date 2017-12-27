package expedia;

import LinkedList.LinkedList;
import LinkedList.ListNode;

public class ReverseLinkedList {
	
	public static void main(String[] args){
		LinkedList<Integer> ll = new LinkedList<>();
		
		ll.addEnd(1);
		ll.addEnd(2);
		ll.addEnd(3);
		//ll.addEnd(4);
		//ll.addEnd(5);
		
		ll.traverse();
		
		LinkedList<Integer> ll2 = new LinkedList<>();
		ll2.setHead(reverseLinkedListRecursive(ll));
		
		ll2.traverse();
	}
	
	public static ListNode reverseLinkedListRecursive(LinkedList ll){
		ListNode current = ll.getHead();
		ListNode nextNode;
		ListNode temp = null;
		
		if(current == null || current.getNext() == null){
			return current;
		}
		
		while(current!=null){
			nextNode = current.getNext();
			current.setNext(temp);
			temp = current;
			current = nextNode;
		}
		
		return temp;
	}
	
	

}
