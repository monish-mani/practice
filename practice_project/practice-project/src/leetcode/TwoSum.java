package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class TwoSum {

	
	Set<Integer> numbers;
	Set<Integer> twoSums;
	
    /** Initialize your data structure here. */
    public TwoSum() {
        numbers = new HashSet<>();
        twoSums = new HashSet<>();
        
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(numbers.size() > 0){
        	Set<Integer> twoSum = numbers.stream().map(Integer::intValue).map(i -> i+number).collect(Collectors.toSet());
            twoSums.addAll(twoSum);
        }
        numbers.add(number);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        return twoSums.contains(value);
    }
    
    
    public static void main(String[] args){
    	
    	TwoSum ts = new TwoSum();
    	ts.add(3);
    	ts.add(2);
    	ts.add(1);
    	System.out.println(ts.find(3));
    }
}

