package Stack;

public class StackMain {
	
	public static void main(String[] args){
		Stack<Integer> s1 = new Stack<>();
		s1.push(1);
		s1.push(2);
		s1.push(3);
		s1.push(4);
		s1.push(5);
		
		s1.traverse();
		System.out.println(s1.size);
		
		s1.pop();
		s1.pop();
		
		s1.push(10);
		s1.push(10);
		s1.push(10);
		s1.push(10);
		s1.traverse();
	}

}
