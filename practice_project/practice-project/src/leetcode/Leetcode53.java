package leetcode;

public class Leetcode53 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode53 lc53 = new Leetcode53();
		//int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		int[] nums = {-1};
		
		System.out.println(lc53.maxSubArray(nums));
	}

	public int maxSubArray(int[] nums) {
		int maxSum=Integer.MIN_VALUE;
		int currSum=nums[0];
		
		for(int i=1;i<nums.length;i++) {
			if(currSum + nums[i] <= 0) {
				currSum=0;
			}else {
				currSum +=nums[i];
			}
			
			if(currSum > maxSum) {
				maxSum = currSum;
			}
		}
		
		return maxSum;

	}

}
