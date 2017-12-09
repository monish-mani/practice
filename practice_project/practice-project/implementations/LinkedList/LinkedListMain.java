package LinkedList;

public class LinkedListMain {
	
	public static void main(String[] args){
		
		LinkedList<Integer> ll = new LinkedList<>();
		
//		System.out.println(ll.isEmpty());
//		ll.addEnd(31);
//		ll.addEnd(32);
//		ll.addEnd(33);
//		ll.addEnd(34);
//		ll.addEnd(35);
//		ll.addEnd(36);
//		System.out.println(ll.size());
//		ll.traverse();
//		ll.addFirst(5);
//		ll.addFirst(4);
//		ll.addFirst(3);
//		ll.addFirst(2);
//		
//		ll.traverse();
//		System.out.println(ll.isEmpty());
//		
//		ll.removeAtPosition(1);
//		ll.insertAtPosition(100, 1);
//		ll.insertAtPosition(1001, 6);
//		ll.traverse();
		
		
		LinkedList<String> ll1 = new LinkedList<String>();
		ll1.addEnd("Monish");
		ll1.addEnd("Anand");
		ll1.addEnd("Amma");
		ll1.addEnd("Christie");
		System.out.println(ll1.size());
		ll1.traverse();
		
		ll1.addFirst("Prathap");
		ll1.insertAtPosition("Permia", ll1.size);
		ll1.traverse();
		
	}

}
