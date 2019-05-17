package leetcode;

public class Leetcode796 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode796 lc796 = new Leetcode796();
		String A = "abcde";
		String B = "cdeab";
		
		System.out.println(lc796.rotateString(A,B));
	}
	
	public boolean rotateString(String A, String B) {
        int aIndex=0;
        int bIndex=0;
        
        int aStart=0;
        
        //Find start index in string A
        for(aIndex=0;aIndex<A.length();aIndex++) {
        	if(A.charAt(aIndex) == B.charAt(bIndex)) {
        		aStart = aIndex;
        		break;
        	}
        }
        
        while(bIndex < B.length()) {
        	if(A.charAt(aIndex) == B.charAt(bIndex)) {
        		aStart = aIndex;
        		bIndex++;
        	}else {
        		bIndex=0;
        	}
        	aIndex++;
        }
    }

}
