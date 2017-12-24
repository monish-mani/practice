package Sort;

import java.util.Arrays;

public class HeapSort {
	/*
	 * Steps for heapsort:
	 * 1. Build max heap --> Tree where all the nodes agree to the max-heap property. This uses max heapify method.
	 * 2. Exchange root with the last element and reduce the heap size by 1. The last element(largest) is in the right position.
	 * 	  Max-heapify position 1 because it was just exchnaged and it does not satisfy max heap property.
	 * 3. Do this for all positions from bottom up to 0.
	 */
	
	public static void main(String[] args){
		
		int[] input = {16,14,10,8,7,9,3,2,4,1};
		int[] input2 = {1,14,10,8,7,9,3,2,4,16};
		int[] output2 = {14,8,10,4,7,9,3,2,1,16};
		int[] input3 = {1,2,5,4,3,10};
		
		heapSort(input3);
		System.out.println(Arrays.toString(input3));
	}
	
	public static void heapSort(int[] input){
		buildMaxHeap(input);
		int heapSize=input.length-1;
		for(int i=input.length-1;i>=0;i--){
			int temp = input[0];
			input[0] = input[heapSize];
			input[heapSize] = temp;
			heapSize--;
			maxHeapify(input,0,heapSize);
		}
	}
	
	
	public static void buildMaxHeap(int[] input){
		//All children are max heaps by themselves.
		//Max heapify all other nodes in the tree. 
		//input.length/2 --> 0
		for(int i=input.length/2;i>=0;i--){
			maxHeapify(input,i,input.length - 1);
		}
	}
	
	public static void maxHeapify(int[] input,int pos,int heapSize){
		if(pos > heapSize ){
			return;
		}
		
		int left = 2 * pos + 1;
		int right = 2*pos + 2;
		
		int maxPosition = pos;
		
		if(left <= heapSize && input[left] > input[maxPosition]){
			maxPosition = left;
		}
		
		if(right <= heapSize && input[right] > input[maxPosition]){
			maxPosition = right;
		}
		
		if(maxPosition!=pos){
			//Exchange numbers between position and max
			int temp = input[pos];
			input[pos] = input[maxPosition];
			input[maxPosition] = temp;
			maxHeapify(input,maxPosition,heapSize);
		}
		
	}

}
