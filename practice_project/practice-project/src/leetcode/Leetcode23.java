package leetcode;
import java.util.*;
import java.util.Collections;;


public class Leetcode23 {
	
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*PriorityQueue<Integer> pq1 = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer l1,Integer l2){
            	//return (l1.intValue() < l2.intValue()) ? -1 : ((l1.intValue() == l2.intValue()) ? 0 : 1);
            	return l1.compareTo(l2);
            }
             
        });
		
		Integer i1 = new Integer(10);
		Integer i2 = new Integer(14);
		
		System.out.println("Compare to " + i1.compareTo(i2));
		
		pq1.add(1);
		pq1.add(10);
		pq1.add(3);
		pq1.add(14);
		pq1.add(-1);
		
		System.out.println(pq1.toString());
*/
		
		Set<Integer> myset = new HashSet<>();
		
		Integer i1 = new Integer(10);
		myset.add(i1);
		
		Integer i2 = new Integer(20);
		myset.add(i2);
		
		Integer i3 = new Integer(30);
		myset.add(i3);
		
		
		Integer i4 = new Integer(40);
		myset.add(i4);
		
		//Before removing.
		System.out.println(myset.size());
		
		
		myset.remove(i1);
		myset.remove(i2);
		
		System.out.println(myset.size());
		
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
			public int compare(ListNode n1,ListNode n2){
				if(n1.val > n2.val){
					return 1;
				}else if(n1.val < n2.val){
					return -1;
				}
				
				return 0;
			}
		});
		
		Set<ListNode> activeLists = new HashSet<>();
		ListNode head = null;
		ListNode curr = null;
		
		
		//Add non null lists to active list set
		for(ListNode list : lists){
			if(list!=null){
				activeLists.add(list);
			}
		}
		
		while(activeLists.size() > 0){
			//Populate queue with 1 element from each list
			for(ListNode list : lists){
				pq.add(list);
				if(list.next == null){
					activeLists.remove(list);
				}else{
					list = list.next;
				}
			}
			
			//Remove elements from PQ
			while(pq.size() > 0){
				ListNode tempNode = pq.poll();
				if(head == null){
					head = tempNode;
					curr = tempNode;
				}else{
					curr.next = tempNode;
					curr = tempNode;
				}
			}
		}
		
		
		return head;
		
	}
	
	
	
	
	
}
