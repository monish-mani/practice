package Sort;

import org.junit.Test;
import Sort.HeapSort;
import static org.junit.Assert.*;

public class HeapSortTest {
	
	
	@Test
	public void maxHeapifyTest(){
		int[] input1 = {16,14,10,8,7,9,3,2,4,1};
		int[] output1 = {16,14,10,8,7,9,3,2,4,1};
		HeapSort.maxHeapify(input1,2,input1.length-1);
		assertArrayEquals(output1,input1);
		
		int[] input2 = {1,14,10,8,7,9,3,2,4,16};
		int[] output2 = {14,8,10,4,7,9,3,2,1,16};
		
		HeapSort.maxHeapify(input2, 0,input2.length-1);
		assertArrayEquals(output2,input2);
		
	}
	
	
	@Test
	public void heapSortTest(){
		int[] input1 = {16,14,10,8,7,9,3,2,4,1};
		int[] output1 = {1,2,3,4,7,8,9,10,14,16};
		HeapSort.heapSort(input1);
		assertArrayEquals(output1,input1);
		
		int[] input2 = {5,4,3,2,1};
		int[] output2 = {1,2,3,4,5};
		HeapSort.heapSort(input2);
		assertArrayEquals(output2,input2);
		
		int[] input3 = {6,6,6,6,6};
		int[] output3 = {6,6,6,6,6};
		HeapSort.heapSort(input3);
		assertArrayEquals(output3,input3);
		
		int[] input4 = {-12,-4,-2,-10,-1};
		int[] output4 = {-12,-10,-4,-2,-1};
		HeapSort.heapSort(input4);
		assertArrayEquals(output4,input4);
		
		int[] input5 = {0,0,0,0};
		int[] output5 = {0,0,0,0};
		HeapSort.heapSort(input5);
		assertArrayEquals(output5,input5);
		
		
		int[] input6 = {100,101,113,120};
		int[] output6 = {100,101,113,120};
		HeapSort.heapSort(input6);
		assertArrayEquals(output6,input6);
	}
	
	

}
