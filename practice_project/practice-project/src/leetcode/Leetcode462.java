package leetcode;

import java.util.Arrays;

public class Leetcode462 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,2,4,10};
		System.out.println(minMoves2(nums));
		//1 2 3 4

	}
	
	public static int minMoves2(int[] nums) {
        int leftMinMoves=0;
        int rightMinMoves=0;
        int leftMid=0;
        int rightMid=0;
        
        Arrays.sort(nums);
        
        leftMid = nums.length/2;
        if(nums.length /2 == 0){
            if(nums.length/2 + 1 < nums.length){
                rightMid = nums.length/2 +1;
            }
            
        }else{
            rightMid = nums.length/2;
        }
        
        
        for(int i=0;i<nums.length;i++){
        	if(i!=leftMid){
        		leftMinMoves+=Math.abs(nums[i] - nums[leftMid]);
        	}
        	if(i!=rightMid){
        		rightMinMoves+=Math.abs(nums[i] - nums[rightMid]);
        	}
        }
        
        return Math.min(rightMinMoves, leftMinMoves);
    }
	
	

}
