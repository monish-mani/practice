package junk;

public class Pivot {
	
	public static void main(String[] args){
		
		int[] nums1 = {5,2,3,4,1};
		int[] nums2 = {9,12,33,54,65,76,87,93,96};
		int[] nums3 = {73,85,94,21,27,34,47,54,66};
		int[] nums4 = {5,2,3,4,5};
		int[] nums5 = {1,2,3,4,5};
		int[] nums6 = {1,2,3,4,5};
		int[] nums7 = {1,2,3,4,5};
		
		System.out.println(findPivot(nums1));
		System.out.println(findPivot(nums2));
		System.out.println(findPivot(nums3));
	}
	
	
	public static int findPivot(int[] nums){
		if(nums == null || nums.length == 0) return -1;
		
		int start =0;
		int end = nums.length-1;
		
		while(start <= end){
			int mid = (start+end)/2;
			
			if(mid!=0 && nums[mid] < nums[mid-1]) return mid;
			
			if(nums[start] <= nums[mid]){//Pivot is in second half
				start = mid + 1;
			}else{
				end = mid - 1;
			}
		}
		
		return -1;
	}

}
