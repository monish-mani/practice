package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode438 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "cbaebabacd";
		String p = "abc";
		
		List<Integer> result = findAnagrams(s, p);
		StringBuilder sb = new StringBuilder();
		result.stream().forEach(i -> sb.append(i + " "));;
		
		System.out.println(sb.toString());
	}
	
	
public static List<Integer> findAnagrams(String s, String p) {
        
        ArrayList<Integer> pAnagramIndexes = new ArrayList<>();
        
        String pHash = generateHash(p,0,p.length()-1);
        
        int start =0;
        int end = p.length()-1;
        
        while(end < s.length()){
            String sHash = generateHash(s,start,end);
            if(sHash.equals(pHash)){
            	pAnagramIndexes.add(start);
            }
            start++;
            end++;
        }
        
        return pAnagramIndexes;
     
        
    }
    
    public static String generateHash(String s,int start,int end){
            int[] charMap = new int[26];
            
            for(int i=start;i<=end;i++){
            charMap[s.charAt(i) - 'a']++;
            }
            
            StringBuilder hash = new StringBuilder();
            for(int i=0;i<charMap.length;i++){
                if(charMap[i]!=0){
                    hash.append((char)(97+i));
                    hash.append(charMap[i]);
                }
            }
            
            return hash.toString();
        }

}
