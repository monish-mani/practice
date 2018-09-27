package leetcode;

public class Leetcode283 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void moveZeroes(int[] nums) {
		if(nums == null || nums.length == 0) return;
		int i=0,j=0;
		while(i < nums.length) {
			if(nums[i] == 0) i++;
		}
		j=i-1;
		
		while(j < nums.length) {
			if(nums[j] == 0) {
				i++;
				j++;
			}else {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				j++;
			}
		}
	}
	

}
