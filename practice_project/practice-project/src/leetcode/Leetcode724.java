package leetcode;

public class Leetcode724 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,7,3,6,5,6};
		System.out.println(pivotIndex(nums));
	}

	public static int pivotIndex(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}

		int rightSum = 0;
		int leftSum = 0;

		for (int i = 0; i < nums.length; i++) {
			rightSum += nums[i];
		}

		int pivot = 0;

		while (pivot < nums.length) {
			rightSum-=nums[pivot];
			if (leftSum == rightSum) {
				return pivot;
			}
			leftSum += nums[pivot];
			
			
			pivot++;
		}

		return -1;
	}

}
