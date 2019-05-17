package leetcode;
import java.util.*;
import java.util.Map.Entry;

public class Leetcode767 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S ="vvvlo";
		System.out.println(reorganizeString(S));
	}
	
	
	public static String reorganizeString(String S) {
        
        int[] count = new int[26];
        
        for(int i=0;i<S.length();i++){
            count[S.charAt(i) - 'a']++;
        }
        
        //Heap will hold array of len 2. 0 pos will be the count, 1 pos will be the ascii value of the char
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        
        //If the count of any char is more than half the length of the string
        //re-arranging is not possible.
        
        int limit = (S.length()+1)/2;
        
        for(int i=0;i<count.length;i++){
            if(count[i] > limit){
                return "";
            }else if(count[i] > 0){
                pq.offer(new int[]{count[i],i+'a'});    
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(pq.size()!=0){
            int[] mostFrequent = pq.poll();
            
            if(sb.length()==0 || sb.charAt(sb.length()-1) != mostFrequent[1]){
                sb.append((char)mostFrequent[1]);
                mostFrequent[0]--;
                if(mostFrequent[0] > 0){
                    pq.offer(mostFrequent);
                }
            }else{
                int[] secondMostFrequent = pq.poll();
                sb.append((char)secondMostFrequent[1]);
                secondMostFrequent[0]--;
                if(secondMostFrequent[0] > 0){
                    pq.offer(secondMostFrequent);
                }
                pq.offer(mostFrequent);
            }
        }
               
        return sb.toString();
    
	}

}
