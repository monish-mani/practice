package leetcode;

import java.util.*;


public class Leetcode13 {

    
	static Map<Character,Integer> romanLiteralValues;
	
	static {
        romanLiteralValues = new HashMap<>();
        
        romanLiteralValues.put('I',1);
        romanLiteralValues.put('V',5);
        romanLiteralValues.put('X',10);
        romanLiteralValues.put('L',50);
        romanLiteralValues.put('C',100);
        romanLiteralValues.put('D',500);
        romanLiteralValues.put('M',1000);
    }
    
    
    public static int romanToInt(String s) {
        //Store roman literal values in hashmap
        int result=0;
        
        int temp=0;
        
        int end=s.length()-1;
        result = romanLiteralValues.get(s.charAt(end));
        int lastLiteralValue=romanLiteralValues.get(s.charAt(end));
        
        for(int i=s.length()-2;i>=0;i--){
            int currentValue = romanLiteralValues.get(s.charAt(i));
            if(currentValue >= lastLiteralValue){
                result+=currentValue;
            }else{
                result-=currentValue;
            }
            
            lastLiteralValue = currentValue;
        }
        
        return result;
    }


    
    public static void main(String[] args){
    	System.out.println(romanToInt("DCXXI"));
    }
	
}
