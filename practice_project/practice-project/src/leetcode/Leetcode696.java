package leetcode;

import java.util.*;

public class Leetcode696 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countBinarySubstrings("0011");
	}
	
	public static int countBinarySubstrings(String s) {
        Set<String> validBinarySubStrings = new HashSet<>();
        Integer result=0;
        
        int start =0;
        int end=s.length()-1;
        
        List<String> allSubStrings = new ArrayList<>();
        
        generateSubStrings(s,start,end,allSubStrings);
        
        return 0;
    }
    
    private static void generateSubStrings(String s,int start,int end,List<String> allSubStrings){
        if(start < end){
            allSubStrings.add(s.substring(start,end));
        }else{
        	return;
        }
        generateSubStrings(s,start+1,end,allSubStrings);
        generateSubStrings(s,start,end-1,allSubStrings);
        
    }

}
