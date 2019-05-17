package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Leetcode819 {

	public static void main(String[] args) {
		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned = {"hit"};
		
		Leetcode819 lc819 = new Leetcode819();
		System.out.println(lc819.mostCommonWord(paragraph, banned));

	}
	
	public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for(String s : banned){
            bannedSet.add(s);
        }
        
        List<String> paraWords =tokenize(paragraph);
        
        Map<String,Long> wordCount = paraWords.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        
        
        Long[] maxCount = new Long[1];
        maxCount[0] = new Long(0);
        String[] mostCommonWord= new String[1];
        
        
        wordCount.keySet().stream().forEach(key -> {if(wordCount.get(key).longValue() > maxCount[0].longValue() && !bannedSet.contains(key)){
                                                        mostCommonWord[0] = key;
                                                        maxCount[0] = wordCount.get(key);
                                                        }
                                                   });
        
        return mostCommonWord[0];
    }
	
	private List<String> tokenize(String paragraph){
		List<String> result = new ArrayList<>();
		
		StringBuilder singleWord = new StringBuilder();
		
		for(int i=0;i<paragraph.length();i++) {
			char c = paragraph.charAt(i);
			int offset=-1;
			if(c >= 'A' && c <= 'Z') {
				offset = c - 'A';
			}else if(c >= 'a' && c <= 'z') {
				offset = c -'a';
			}
			
			if(offset!=-1) {
				singleWord.append((char)('a' + offset));
			}else {
				result.add(singleWord.toString());
				singleWord = new StringBuilder();
			}
		}
		//result.add(singleWord.toString());
		return result;
	}

}
