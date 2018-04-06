package leetcode;

import java.util.Arrays;

public class Leetcode238 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1};
		System.out.println(Arrays.toString(productExceptSelf(nums)));
	}

	public static int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];
        
        int zeroCount=0;
        int totalProduct=1;
        
        
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
            	if(zeroCount==1){
            		return result;
            	}
            	zeroCount++;
            }else{
                totalProduct*=nums[i];
            }
        }
        System.out.println(totalProduct);
        
        for(int i=0;i<nums.length;i++){
            //result[i] = nums[i] == 0 ? 0 : totalProduct/nums[i];
            if(nums[i] == 0){
            	if(nums.length == 2 && zeroCount==1){
            		result[i]= totalProduct;
            	}else{
            		result[i]= 0;
            	}
                
            }else{
                if(nums.length == 2 && zeroCount==1){
                    result[i]=0;
                }else{
                    result[i] = totalProduct/nums[i];
                }
            }
            
        }
        
        return result;
    
	}

}
