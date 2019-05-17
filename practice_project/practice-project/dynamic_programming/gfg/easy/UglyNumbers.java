package gfg.easy;

import java.util.HashSet;
import java.util.Set;

public class UglyNumbers {
	
	public static void main(String[] args) {
		UglyNumbers un = new UglyNumbers();
		System.out.println(un.getUglyNumber(13));;
	}
	
	//Bottom up
	public int getUglyNumber(int n) {
		Set<Integer> uglyNumbers = new HashSet<>();
		uglyNumbers.add(1);
		n=n-1;
		int start=2;
		
		while(n > 0) {
			if(start%2 == 0 && uglyNumbers.contains(start/2)) {
				uglyNumbers.add(start);
				n--;
			}else if(start%3 == 0 && uglyNumbers.contains(start/3)) {
				uglyNumbers.add(start);
				n--;
			}else if(start%5 == 0 && uglyNumbers.contains(start/5)) {
				uglyNumbers.add(start);
				n--;
			}
			start++;
		}
		
		return start-1;
	}

}
