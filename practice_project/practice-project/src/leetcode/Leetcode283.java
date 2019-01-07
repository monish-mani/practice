package leetcode;

import java.util.Arrays;

public class Leetcode283 {

	public static void main(String[] args) {
		Leetcode283 lc283 = new Leetcode283();
		//int a[] = {0,1,0,3,12};
		int a[] = {1,0};
		lc283.moveZeroes(a);
		System.out.println(Arrays.toString(a));

	}
	
	public void moveZeroes(int[] nums) {
		int nextZeroPos = findNextZeroPos(nums,0);
		
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=0 && nextZeroPos >= 0 && nextZeroPos < i) {
				swap(nums,i,nextZeroPos);
				nextZeroPos = findNextZeroPos(nums,nextZeroPos);
			}
		}
	}
	
	private int findNextZeroPos(int[] nums, int currPos) {
		while(currPos < nums.length && nums[currPos]!=0) {
			currPos++;
		}
		return  currPos < nums.length ? currPos : -1;
	}
	
	private void swap(int[] nums, int pos1, int pos2) {
		int temp = nums[pos1];
		nums[pos1] = nums[pos2];
		nums[pos2] = temp;
	}

}
