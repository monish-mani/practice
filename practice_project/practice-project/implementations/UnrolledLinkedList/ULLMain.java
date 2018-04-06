package UnrolledLinkedList;

public class ULLMain {
	
	public static void main(String[] args){
		UnrolledLinkedList ULL = new UnrolledLinkedList(4);
		
		ULL.add(1);
		ULL.add(2);
		ULL.add(3);
		ULL.add(4);
		
		
		
		System.out.println(ULL.search(10));
		System.out.println(ULL.search(2));
		System.out.println(ULL.search(4));
		System.out.println(ULL.search(10));
	}

}
