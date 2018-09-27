package leetcode;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Leetcode884 {
	
	public static void main(String[] args) {
		String A = "this apple is sweet";
		String B = "this apple is sour";
		
		Leetcode884 lc884 = new Leetcode884();
		
		List<String> aList = lc884.convertToWordList(A);
		List<String> bList = lc884.convertToWordList(B);
		
		Map<String, Long> wordCountMap = aList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		wordCountMap.putAll(bList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
		
		List<String> result = new ArrayList<>();
		
		wordCountMap.keySet().stream().forEach(k -> {
			if(wordCountMap.get(k) == 1) result.add(k);
		});
		
		
		//System.out.println(result);
		Map<String,Integer> map1 = new HashMap<>();
		Map<String,Integer> map2 = new HashMap<>();
		Map<String,Integer> map3 = new HashMap<>();
		
		map1.put("monish",1);
		map1.put("tim",1);
		map1.put("tims",1);
		map1.put("timsy",1);
		
		
		map2.put("monish",2);
		map2.put("tim",2);
		map2.put("tims",2);
		map2.put("timsy",2);
		
		map3.putAll(map1);
		map3.putAll(map2);
		
		System.out.println();
	}
	
	private List<String> convertToWordList(String sentence){
		List<String> wordList = Arrays.asList(sentence.split(" "));
		return wordList;
	}

}
