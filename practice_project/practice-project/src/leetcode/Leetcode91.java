package leetcode;

public class Leetcode91 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode91 lc91 = new Leetcode91();
		String s="10";
		System.out.println(lc91.numDecodings(s));
	}
	
	public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        
        int result=0;
        
        return getNumDecodings(s,0,0,0);
    }
    
    private int getNumDecodings(String s,int startIndex,int endIndex,int numOfDecodings){
        if(endIndex >= s.length()) return numOfDecodings;
        
        if(Integer.parseInt(s.substring(startIndex, endIndex+1)) <= 2 ){
        	return Math.max(getNumDecodings(s,startIndex+1,endIndex+1,numOfDecodings+1) , getNumDecodings(s,startIndex,endIndex+1,numOfDecodings));
        }else if(Integer.parseInt(s.substring(startIndex,endIndex+1)) <= 26){
        	return getNumDecodings(s,endIndex+1,endIndex+1,numOfDecodings+1);
        }
        
        return getNumDecodings(s,startIndex+1,endIndex,numOfDecodings);
    }

}
