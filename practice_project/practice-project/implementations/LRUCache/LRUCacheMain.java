package LRUCache;

public class LRUCacheMain {
	
	public static void main(String[] args){
		LRUCache<Integer,String> testLRUCache = new LRUCache<>(5);
		
		testLRUCache.put(1, "Monish");
		testLRUCache.put(2, "Anand");
		testLRUCache.put(3, "Amma");
		testLRUCache.put(4, "Christy");
		testLRUCache.put(5, "Pughalendhi");
		testLRUCache.put(6, "Ashok");
		testLRUCache.put(7, "Arun");
		
		
		System.out.println(testLRUCache.get(1));
		System.out.println(testLRUCache.get(2));
		System.out.println(testLRUCache.get(3));
		System.out.println(testLRUCache.get(4));
		System.out.println(testLRUCache.get(5));
		
		
		System.out.println(testLRUCache.get(6));
		System.out.println(testLRUCache.get(7));
		System.out.println(testLRUCache.get(8));
		
	}

}
