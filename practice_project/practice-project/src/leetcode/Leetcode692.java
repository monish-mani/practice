package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode692 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode692 lc692 = new Leetcode692();
		
		String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
		int k=1;
		System.out.println(lc692.topKFrequent(words, k));
	}
	
	public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> countMap = new HashMap<>();
        
        for(String word : words){
            countMap.put(word,countMap.getOrDefault(word,0)+1);
        }
        
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>((a,b) -> {
            if(a.getValue() == b.getValue()){
                return b.getKey().compareTo(a.getKey());
            }else{
                return a.getValue() - b.getValue();
            }
        });
        
        for(Map.Entry<String,Integer> entry : countMap.entrySet()){
            if(pq.size() == k){
                if(entry.getValue() > pq.peek().getValue()){
                    pq.poll();
                    pq.offer(entry);
                }
            }else{
                pq.offer(entry);
            }
        }
        
        List<String> result = new ArrayList<>();
        
        while(pq.size()!=0){
            result.add(0,pq.poll().getKey());
        }
        
        return result;
    }

}
