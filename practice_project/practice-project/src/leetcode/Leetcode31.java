package leetcode;

import java.util.Arrays;

public class Leetcode31 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,2,3};
		int[] nums2 = {3,2,1};
		int[] nums3 = {1,3,2};
		nextPermutation(nums1);
		nextPermutation(nums2);
		nextPermutation(nums3);
		
		System.out.println(Arrays.toString(nums1));
		System.out.println(Arrays.toString(nums2));
		System.out.println(Arrays.toString(nums3));
	}
	
	
	
	public static void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1){
            return;
        }
        
        int furthestShiftIndex=-1;
        
        for(int i=1;i<nums.length;i++){
            if(nums[i-1] < nums[i]){
                furthestShiftIndex=i;
            }
        }
        
        System.out.println("Furthest index " + furthestShiftIndex);
        //If numbers in the array are pure descending
        if(furthestShiftIndex < 0){
            //Completely reverse the elements to form the smallest number possible
            reverseArrayPartially(nums,0,nums.length-1);
            return;
        }
        
        //Swap i and i+1
        int temp = nums[furthestShiftIndex];
        nums[furthestShiftIndex] = nums[furthestShiftIndex-1];
        nums[furthestShiftIndex-1] = temp;
        
        //Reverse the part to the right of the shift index if there is.
        //There right part of the shift index is purely descending. 
        //We need to get the smallest number possible out of that part.
        
        if(furthestShiftIndex == nums.length - 1){
            return;
        }
        
        //Reverse(nums,i+1,nums.length-1)
        reverseArrayPartially(nums,furthestShiftIndex+1,nums.length-1);
        
        return;
    }
    
    
    public static void reverseArrayPartially(int[] nums,int start,int end){
        if(nums == null || start == end || end - start == 1){
            return;
        }
        
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        
        return;
    }

}
