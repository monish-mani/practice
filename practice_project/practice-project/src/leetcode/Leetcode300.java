package leetcode;

public class Leetcode300 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={1,3,6,7,9,4,10,5,6};
		
		System.out.println(lengthOfLIS(nums));
	}
	
	public static int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] LIS = new int[nums.length];
        
        //Populate LIS array with with since each element trivially forms an LIS of length 1
        for(int i=0;i<nums.length;i++){
            LIS[i]=1;
        }
        
        for(int i=1;i<nums.length;i++){
            int max=0;
            for(int j=i-1;j>=0;j--){
                if(nums[i] > nums[j] && max < LIS[j] + 1){
                    max = LIS[j] + 1;
                }
            }
            LIS[i] = max > LIS[i] ? max : LIS[i];
        }
        
        int maxLISLength=0;
        for(int i=0;i<LIS.length;i++){
        	if(maxLISLength < LIS[i]) maxLISLength = LIS[i];
        }
        
        return maxLISLength;
    }

}
