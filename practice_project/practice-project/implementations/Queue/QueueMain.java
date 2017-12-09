package Queue;

public class QueueMain {
	
	public static void main(String[] args){
		Queue<Integer> q1 = new Queue<>();
		
		q1.insert(1);
		System.out.println(q1.peek().getVal());
		q1.insert(2);
		q1.insert(3);
		q1.insert(4);
		System.out.println(q1.peek().getVal());
		q1.insert(5);
		q1.size();
		
		q1.traverse();
		
		q1.remove();
	
		
		q1.traverse();
		
		
		Queue<String> q2 = new Queue<>();
		q2.insert("Monish");
		System.out.println(q2.peek().getVal());
		q2.insert("Anand");
		q2.insert("Amma");
		q2.insert("Christie");
		System.out.println(q2.peek().getVal());
		q2.traverse();
	}

}
