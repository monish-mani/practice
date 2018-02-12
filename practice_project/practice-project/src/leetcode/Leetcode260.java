package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class Leetcode260 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 1, 3, 2, 5};
		int[] nums2 = {4,4,4,4,4,4,4,4,4,5,4,6};
		int[] nums3 = {43772400,1674008457,1779561093,744132272,1674008457,448610617,1779561093,
		               124075538,-1034600064,49040018,612881857,390719949,-359290212,-812493625,
		               124732,-1361696369,49040018,-145417756,-812493625,2078552599,1568689850,
		               865876872,865876872,-1471385435,1816352571,1793963758,2078552599,-1034600064,
		               1475115274,-119634980,124732,661111294,-1813882010,1568689850,448610617,1347212898,
		               -1293494866,612881857,661111294,-1361696369,1816352571,-1813882010,-359290212,1475115274,
		               1793963758,1347212898,43772400,-1471385435,124075538,-1293494866,-119634980,390719949};
		
		System.out.println(Arrays.toString(singleNumber(nums)));
		System.out.println(Arrays.toString(singleNumber(nums2)));
		System.out.println(Arrays.toString(singleNumber(nums3)));
		
		LinkedList<Integer> queue = new LinkedList<>();
		while(!queue.isEmpty()){
			
		}

	}
	
	
	public static int[] singleNumber(int[] nums) {
        int xor=0;
        
        for(int i=0;i<nums.length;i++){
            xor^=nums[i];
        }
        
        //Find the rightmost set bit
        int rightMostSetBitPosition=0;
        int filter=1;
        while(xor != 0){
            if((xor & filter) != 0){
                break;
            }
            rightMostSetBitPosition++;
            filter = filter << 1;
        }
        
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            if((nums[i] & filter) != 0){
                result[0]^=nums[i];
            }else{
                result[1]^=nums[i];
            }
        }
        
        return result;
    }

}
