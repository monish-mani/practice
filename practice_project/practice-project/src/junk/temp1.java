package junk;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class temp1 {
	
	public static void main(String[] args){
		Set<Integer> numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);
		
		int newNumber = 10;
		
		Set<Integer> twoSum = numbers.stream().map(Integer::intValue).map(i -> i+newNumber).collect(Collectors.toSet());
		
		Set<Integer> twoSums = new HashSet<Integer>();
		twoSums.add(600);
		twoSums.addAll(twoSum);
		for(Integer i : twoSums){
			System.out.println(i);
		}
		
	}

}
