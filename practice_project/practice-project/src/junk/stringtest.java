package junk;

import java.util.Arrays;
import java.util.HashSet;

public class stringtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = null;
		String b = "monish";
		System.out.println(b + a);
		
		
		String c = "FREE BREAKFAST, FREE WIFI, FREE PARKING";
		System.out.println(c.contains("free BREAKFAST"));
		
		
		String[] tempArray = null;//{"abcd","efgh"};
		HashSet<String> tempSet = new HashSet<String>(Arrays.asList(tempArray));
		HashSet<String> tempSet1 = null;
		
		System.out.println(tempSet);
		System.out.println(tempSet1 == null);
	}

}
