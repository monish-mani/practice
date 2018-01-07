package leetcode;

public class Leetcode551 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="PPALLP";
		String s2="PPALLL";
		
		System.out.println(checkRecord(s1));
		System.out.println(checkRecord(s2));
	}
	
	
	public static boolean checkRecord(String s) {
        boolean containsA=false;
        int consecutiveLCount=0;
        
        if(s == null || s.length() == 0){
            return true;
        }
        
        for(char c : s.toCharArray()){
            switch (c) {
            
            case 'A' :
            	if(containsA){
            		return false;
            	}
            	containsA=true;
            	consecutiveLCount=0;
            	break;
            case 'L':
            	if(consecutiveLCount == 2){
            		return false;
            	}
            	consecutiveLCount++;
            	break;
            	
            case 'P':
            	consecutiveLCount=0;
            	break;
            }
            
        }
        
        return true;
        
    }

}
