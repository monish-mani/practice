package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode347 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode347 lc347 = new Leetcode347();
		int[] nums = {1,1,1,2,2,3};
		int k = 2;
		
		System.out.println(lc347.topKFrequent(nums, k));
	}
	
	public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> countMap = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            countMap.put(nums[i],countMap.getOrDefault(nums[i],0)+1);
        }
        
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b) ->  a.getValue() - b.getValue());
        
        for(Map.Entry<Integer,Integer> entry : countMap.entrySet()){
            if(pq.size() == k){
                if(entry.getValue() > pq.peek().getValue()){
                    pq.poll();
                    pq.offer(entry);
                }
            }else{
                pq.offer(entry);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        while(pq.size()!=0){
            result.add(pq.poll().getKey());
        }
        
        return result;
    }

}
