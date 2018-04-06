package leetcode;
import java.util.*;
import java.util.Map.Entry;

public class Leetcode767 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S ="aaabbc";
		reorganizeString(S);
	}
	
	
	public static String reorganizeString(String S) {
		
		PriorityQueue<Entry<Character, Integer>> pq = new PriorityQueue<>(new Comparator<Entry<Character,Integer>>(){
			public int compare(Map.Entry<Character, Integer> e1,Map.Entry<Character, Integer> e2){
				return e2.getValue().compareTo(e1.getValue());
			}
		});
		
		Map<Character,Integer> charCountMap = new HashMap<>();
		
        for(int i=0;i<S.length();i++){
            int count = charCountMap.getOrDefault(S.charAt(i), 0);
            charCountMap.put(S.charAt(i), ++count);
        }
        
        
        for(Entry<Character,Integer> entry : charCountMap.entrySet()){
        	pq.add(entry);
        }
        
        
        StringBuilder result = new StringBuilder();
        Entry<Character,Integer> highestEntry = pq.poll();
        Entry<Character,Integer> secondHighestEntry = pq.poll();
        
        //if()
        
        System.out.println();
        return null;
    }

}
