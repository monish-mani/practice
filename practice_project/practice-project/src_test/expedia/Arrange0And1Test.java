package expedia;

import static org.junit.Assert.*;

import org.junit.Test;
import static expedia.Arrange0And1.*;

public class Arrange0And1Test {
	
	
	@Test
	public void arrange0And1Test(){
		int[] input1 = {0,0,0,0};
		int[] output1 = {0,0,0,0};
		
		assertArrayEquals(output1,rearrange(input1));
		
		int[] input2 = {0,1,0,1,0,1};
		int[] output2 = {0,0,0,1,1,1};
		
		assertArrayEquals(output2,rearrange(input2));
		
		int[] input3 = {0,0,0,0,1,1,1,1};
		int[] output3 = {0,0,0,0,1,1,1,1};
		
		assertArrayEquals(output3,rearrange(input3));
		
		int[] input4 = {1,1,1,1};
		int[] output4 = {1,1,1,1};
		
		assertArrayEquals(output4,rearrange(input4));
		
		int[] input5 = {0,0,1,1,1,1,1,0,0,0};
		int[] output5 = {0,0,0,0,0,1,1,1,1,1};
		
		assertArrayEquals(output5,rearrange(input5));
	}

}
