package leetcode;

import java.util.*;

public class Leetcode500 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode500 lc500 = new Leetcode500();
		
		String[] words = {"Hello", "Alaska", "Dad", "Peace"};
		String[] result = lc500.findWords(words);
		
		System.out.println(Arrays.toString(result));

	}
	
	public String[] findWords(String[] words) {
        int[] charRowMap = {2,3,3,2,1,2,2,2,1,2,2,2,3,3,1,1,1,1,2,1,1,3,1,3,1,3};
        
        List<String> result = new ArrayList<>();
        
        for(String word : words){
            char c = word.charAt(0);
            int row = c >= 'A' && c <= 'Z' ? charRowMap[c - 'A'] : charRowMap[c - 'a'];
            boolean sameRow = true;
            
            for(int i=1;i<word.length();i++){
            	int currRow = word.charAt(i) >= 'A' && word.charAt(i) <= 'Z' ? charRowMap[word.charAt(i) - 'A'] : charRowMap[word.charAt(i) - 'a'];
                if(row!=currRow){
                    sameRow = false;
                    break;
                }
            }
            
            if(sameRow){
                result.add(word);
            }
        }
        
        String[] resultArr = new String[result.size()];
        resultArr = result.toArray(resultArr);
        return resultArr;
    }

}
