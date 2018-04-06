package expedia;

import LinkedList.LinkedList;
import LinkedList.ListNode;

public class GroupOddEvenLinkedList {
	
	public static void main(String[] args){
		LinkedList<Integer> ll = new LinkedList<>();
		ll.addFirst(1);
		ll.addFirst(2);
		ll.addFirst(3);
		ll.addFirst(4);
		ll.addFirst(5);
		ll.addFirst(6);
		ll.addFirst(7);
		ll.addFirst(8);
		ll.addFirst(9);
		ll.addFirst(10);
		
		
		
		
	}
	
	
	public void groupOddEven(LinkedList<Integer> list){
		if(list == null || list.getSize() == 0){
			return;
		}
		
		LinkedList<Integer> oddHead = new LinkedList<>();
		LinkedList<Integer> evenHead = new LinkedList<>();
		
		
		ListNode head = list.getHead();
		
		
		
	}

}
