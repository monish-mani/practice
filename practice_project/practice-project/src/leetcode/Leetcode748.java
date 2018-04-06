package leetcode;

import java.util.*;

public class Leetcode748 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String licensePlate = "GrC8950";
		String[] words = {"measure","other","every","base","according","level","meeting","none","marriage","rest"};
		System.out.println(shortestCompletingWord(licensePlate, words));

	}
	
	
	public static String shortestCompletingWord(String licensePlate, String[] words) {
        HashMap<Character,Integer> licensePlateCharMap = new HashMap<>();
        
        //1.Populate licensePlateCharMap(ignoring case -> i.e. all lowercase)
        if(licensePlate == null || licensePlate.length() == 0){
            return null;
        }
        for(int i=0;i<licensePlate.length();i++){
            char currChar = licensePlate.charAt(i);
            //Process only alphabetical characters
            if((int)currChar >= 'A' && (int)currChar <= 'Z' || ((int)currChar >= 'a' && (int)currChar <= 'z')){
                if((int)currChar >= 'A' && (int)currChar <= 'Z'){
                    int offset = (int)currChar - 'A';
                    currChar = (char)('a' + offset);
                }
                
                int charCount = licensePlateCharMap.getOrDefault(currChar,0);
                charCount++;
                licensePlateCharMap.put(currChar,charCount);
            }
            
        }
        
        String shortestCompletingWord="";
        int shortestCompletingWordLength=Integer.MAX_VALUE;
        
        //2.Generate an array char map for each word(ignoring case -> i.e. all lowercase)
        for(String word : words){
            int[] charMap = new int[26];
            for(int i=0;i<word.length();i++){
                charMap[(int)word.charAt(i) - 'a']++;
            }
            
            //Validate if this is a completing word
            boolean validWord = true;
            for(Character c : licensePlateCharMap.keySet()){
                if(licensePlateCharMap.get(c) > charMap[(int)c.charValue() - 'a']){
                    validWord = false;
                }
            }
            
            if(validWord && word.length() < shortestCompletingWordLength){
                shortestCompletingWord = word;
                shortestCompletingWordLength = word.length();
            }
        }
        
       return shortestCompletingWord; 
    }

}
