package junk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class temp3 {
	
	public static void main(String[] args) {
		final int a = 100;
		
		final int[] arr = new int[10];
		int[] arr2 = new int[30];
		
		for(int i=0;i<arr.length;i++) {
			arr2[i] = 100;
		}
		
		arr[8] = arr2[0];
		
		System.out.println(Arrays.toString(arr));
		
	}
	
}
