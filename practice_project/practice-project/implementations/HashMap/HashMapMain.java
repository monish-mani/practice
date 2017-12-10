package HashMap;

public class HashMapMain {
	
	public static void main(String[] args){
		
		HashMap<Integer,String> hm = new HashMap<>();
		
		hm.put(20, "Monish");
		hm.put(30, "Prathap");
		hm.put(40, "Priya");
		hm.put(30,"Monica");
		hm.put(30, "Monica");
		
//		hm.remove(30, "Monica");
//		hm.remove(30, "Prathap");
//		hm.remove(20, "Monish");
//		hm.remove(40, "Priya");
		
		
		hm.put(2009, "abcd");
		hm.put(3087, "cdef");
		hm.put(1000, "aksdjfh");
		hm.put(999,"pup");
		hm.put(567, "ppp");
		hm.put(234, "ooo");
		hm.put(434, "mkm");
		hm.put(307,"toddles");
		hm.put(20,"bummer");
		hm.put(20,"Monish");
		hm.put(20,"Mon");
		
		
		
		
//		hm.remove(2009, "abcd");
//		hm.remove(3087, "cdef");
//		hm.remove(1000, "aksdjfh");
//		hm.remove(999,"pup");
//		hm.remove(567, "ppp");
//		hm.remove(234, "ooo");
//		hm.remove(434, "mkm");
//		hm.remove(307,"toddles");
		
		hm.traverse();
		
	}

}
