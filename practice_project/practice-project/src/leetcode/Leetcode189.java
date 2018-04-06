package leetcode;

import java.util.Arrays;

public class Leetcode189 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={1,2};
		rotate(nums,1);
		System.out.println(Arrays.toString(nums));
	}
	
	public static void rotate(int[] nums, int k) {
        int start = 0;
        int end = nums.length-1;
        k = k > nums.length ? k%nums.length : k;
        reverseSubarray(nums,start,end-k);
        reverseSubarray(nums,end-k+1,end);
        reverseSubarray(nums,start,end);
    }
    
    private static void reverseSubarray(int[] nums,int start,int end){
        if(nums == null || start > end) return;
        
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        
    }

}
