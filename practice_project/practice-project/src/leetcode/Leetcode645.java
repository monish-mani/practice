package leetcode;

import java.util.Arrays;

public class Leetcode645 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={1,2,2,4};
		System.out.println(Arrays.toString(findErrorNums(nums)));
	}

	public static int[] findErrorNums(int[] nums) {

		// original - 4,2,3,1
		// nums - -1,2,2,-4
		int[] result = new int[2];

		for (int i = 0; i < nums.length; i++) {
			if (nums[Math.abs(nums[i])-1] < 0) {
				result[0] = Math.abs(nums[i]);
			}else{
				nums[Math.abs(nums[i]) - 1] = -1 * nums[Math.abs(nums[i]) - 1];
			}
			
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				result[1] = i + 1;
				break;
			}
		}

		return result;
	}

}
