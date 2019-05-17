package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode821 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "aaba";
		char C = 'b';
		
		Leetcode821 lc821 = new Leetcode821();
		
		System.out.println(Arrays.toString(lc821.shortestToChar(S, C)));;
	}
	
	
	public int[] shortestToChar(String S, char C) {
        List<Integer> cPosList = new ArrayList<>();
        
        for(int i=0;i<S.length();i++){
            if(S.charAt(i) == C){
                cPosList.add(i);
            }
        }
        
        int left = -1;
        int right = 0;
        
        int[] result = new int[S.length()];
        
        for(int i=0;i<S.length();i++){
            int leftDistance = (left >=0 && left < cPosList.size()) ? Math.abs(cPosList.get(left) - i) : (Integer.MAX_VALUE - i);
            int rightDistance = (right >=0 && right < cPosList.size()) ? Math.abs(cPosList.get(right) - i) : (Integer.MAX_VALUE - i);
            
            result[i] = Math.min(leftDistance,rightDistance);
            if(rightDistance == 0){
                left++;
                right++;
            }
        }
        
        return result;
    }

}
