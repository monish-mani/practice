package leetcode;

public class Leetcode657 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String moves1 = "RLUD";
		String moves2 = "RRRR";
		String moves3 = "UUUDDD";
		String moves4 = "RLRLRL";
		String moves5 = "UDUDUD";
		String moves6 = "UURRDDLL";
		String moves7 = "";
		
		
		System.out.println(judgeCircle(moves1));
		System.out.println(judgeCircle(moves2));
		System.out.println(judgeCircle(moves3));
		System.out.println(judgeCircle(moves4));
		System.out.println(judgeCircle(moves5));
		System.out.println(judgeCircle(moves6));
		System.out.println(judgeCircle(moves7));
		

	}
	
	
		public static boolean judgeCircle(String moves) {
	        /*
	        * up - +1
	        * down - -1
	        * right - +1
	        * left - -1
	        */
	        
	        int upDownMovement=0;
	        int leftRightMovement=0;
	        
	        for(char c : moves.toCharArray()){
	            switch(c){
	            case 'R' :
	            	leftRightMovement++;
	            	break;
	            case 'L' : 
	            	leftRightMovement--;
	            	break;
	            case 'U':
	            	upDownMovement++;
	            	break;
	            case 'D':
	            	upDownMovement--;
	            	break;
	            }
	        }
	        
	        return upDownMovement == 0 && leftRightMovement==0;
	    }

}
