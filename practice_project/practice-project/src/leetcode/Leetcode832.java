package leetcode;

import java.util.Arrays;

public class Leetcode832 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode832 lc832 = new Leetcode832();
		int[][] A ={{1,1,0},
					{1,0,1},
					{0,0,0}};
		
		int[][] result = lc832.flipAndInvertImage(A);
		System.out.println(Arrays.deepToString(result));
	}
	
	public int[][] flipAndInvertImage(int[][] A) {
        if(A == null || A.length == 0){
            return A;
        }
        
        for(int i=0;i<A.length;i++){
            int start=0;
            int end=A[i].length-1;
            
            while(start <= end){
                if(A[i][start] == A[i][end]){
                    if(A[i][start] == 0){
                        A[i][start]=1;
                        A[i][end]=1;
                    }else{
                        A[i][start]=0;
                        A[i][end]=0;
                    }
                }
                start++;
                end--;
            }
        }
        
        return A;
    }

}
