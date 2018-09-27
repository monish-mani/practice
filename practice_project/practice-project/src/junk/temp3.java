package junk;

import java.util.ArrayList;
import java.util.List;

public class temp3 {
	
	public static void main(String[] args){
		
		int a = 3;
		long b = 4;
		
		System.out.println(b > a);
		
	}
	
	public static int hammingWeight(int n) {
        int result=0;
        while(n > 0){
            if((n & 1) == 1) result++;
            n = n >> 1;
        }
        
        return result;
    }

}
