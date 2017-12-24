package expedia;

import static org.junit.Assert.*;
import static expedia.CompressWords.*;

import org.junit.Test;

public class CompressWordsTest {


	
	@Test
	public void compressWordsTest(){
		String input1="monish";
		assertEquals("m1o1n1i1s1h1",compressWord(input1));
		
		String input2="";
		assertEquals("",compressWord(input2));
		
		String input3="mmmmm";
		assertEquals("m5",compressWord(input3));
		
		String input4="mmmmmmmmo";
		assertEquals("m8o1",compressWord(input4));
		
		String input5="abbbabaccccc";
		assertEquals("a1b3a1b1a1c5",compressWord(input5));
	}

}
