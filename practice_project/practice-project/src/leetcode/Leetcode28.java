package leetcode;

public class Leetcode28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(strStr("mississippi","issip"));
	}
	
	public static int strStr(String haystack, String needle) {

        if(haystack == null && needle == null) return 0;
        
        if(needle == null || needle.length() == 0) return 0;
        
        if(needle.length() > haystack.length()) return -1;
        
        int needleIndex=0;
        int hayIndex=0;
        
        while(needleIndex < needle.length() && hayIndex < haystack.length()){
            if(needleIndex == needle.length()) return hayIndex - needleIndex;
            
            if(needle.charAt(needleIndex) == haystack.charAt(hayIndex)){
                needleIndex++;
                
            }else{
                //Important! -> Need to rollback haystart back to where it started as it may have parsed part of needle.
                //Example: H ->mississippi, N -> issip
            	hayIndex = hayIndex-needleIndex;
            	needleIndex=0;
            }
            hayIndex++;
        }
        
        return needleIndex == needle.length() ? hayIndex - needleIndex : -1;
    
    
	}

}
