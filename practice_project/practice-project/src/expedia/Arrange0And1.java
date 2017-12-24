package expedia;

import java.util.Arrays;

public class Arrange0And1 {
	
	//Move all zero's to beginning and 1's to the end of the array.
	public static void main(String[] args){
		
		int[] input1 = {0,1,0,1,0,1};
		int[] input2 = {0};
		int[] input3 = {1};
		int[] input4 = {1,1,1,0,0,0};
		int[] input5 = {0,0,0};
		System.out.println(Arrays.toString(rearrange(input1)));
		System.out.println(Arrays.toString(rearrange(input2)));
		System.out.println(Arrays.toString(rearrange(input3)));
		System.out.println(Arrays.toString(rearrange(input4)));
		System.out.println(Arrays.toString(rearrange(input5)));
	}
	
	
	public static int[] rearrange(int[] input){
		if(input == null || input.length == 0){
			return input;
		}
		
		int nextAvailableOnePosition=0;
		while(nextAvailableOnePosition < input.length){
			if(input[nextAvailableOnePosition] == 1){
				break;
			}
			nextAvailableOnePosition++;
		}
		
		
		int index=nextAvailableOnePosition;
		while(index < input.length && nextAvailableOnePosition < input.length){
			if(input[index] == 0 ){
				int temp = input[nextAvailableOnePosition];
				input[nextAvailableOnePosition] = input[index];
				input[index] = temp;
				
				nextAvailableOnePosition++;
			}
			index++;
		}
		
		
		return input;
	}

}
