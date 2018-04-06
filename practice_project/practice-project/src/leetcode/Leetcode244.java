package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Leetcode244 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,Integer> md1 = new HashMap<>();
		HashMap<String,ArrayList<Integer>> minDistanceMap = new HashMap<>();
		HashMap<String,Integer> mostRecentPositionMap = new HashMap<>();
		
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		
        constructMapsForWordDistance(mostRecentPositionMap,md1,words);
        
        constructMapsForWordDistance1(minDistanceMap,mostRecentPositionMap,words);
        
        String[] words2={"this","is","a","long","run","sentence","is","fun","day","today","sunny","weather","is","a","day","tuesday","this","sentence","running","rainy"};
        //constructMapsForWordDistance(mostRecentPositionMap,minDistanceMap,words2);
        
        System.out.println();
		
	}
	
	private static void constructMapsForWordDistance1(HashMap<String,ArrayList<Integer>> minDistanceMap,HashMap<String,Integer> mostRecentPositionMap,String[] words){
		//Get distinct words from input
		List<String> distinctWords = Arrays.asList(words).stream().distinct().collect(Collectors.toList());
		
		//Initialize the most recent position of each word as -1
				for(String word : distinctWords){
					mostRecentPositionMap.put(word, -1);
				}
				
		//Initialize minDistanceMap with Integer.MAX_VALUE
		ArrayList<Integer> dummyList = new ArrayList<>();
		for(int i=0;i<distinctWords.size();i++){
			dummyList.add(Integer.MAX_VALUE);
		}
		distinctWords.stream().forEach(word -> minDistanceMap.put(word, new ArrayList<>(dummyList)));
		
		//Iterate through words[] and populate/update minDistanceMap
		for(int index=0;index<words.length;index++){
			String currentWord = words[index];
			mostRecentPositionMap.put(currentWord, index);
			
			ArrayList<Integer> distanceListForCurrentWord = minDistanceMap.get(currentWord);
			for(int j=0;j<distinctWords.size();j++){
				String otherWord = distinctWords.get(j);
				if(!otherWord.equals(currentWord)){
					if(mostRecentPositionMap.get(otherWord) >= 0 && (index - mostRecentPositionMap.get(otherWord) < distanceListForCurrentWord.get(j))){
						distanceListForCurrentWord.set(j, index - mostRecentPositionMap.get(otherWord));
						minDistanceMap.put(currentWord, distanceListForCurrentWord);
						
						//Also update the list corresponding to the otherWord
						//ArrayList<Integer> distanceListForOtherWord = minDistanceMap.get(otherWord);
						//distanceListForOtherWord.add(index,)
					}
				}
			}
		}
	}
	

	
	
	private static void constructMapsForWordDistance(HashMap<String,Integer> mostRecentPositionMap,HashMap<String,Integer> minDistanceMap, String[] words){
		
		//Get distinct words from input
		List<String> distinctWords = Arrays.asList(words).stream().distinct().collect(Collectors.toList());
		
		//Initialize the most recent position of each word as -1
		for(String word : distinctWords){
			mostRecentPositionMap.put(word, -1);
		}
		
		//Generate all 2 word combinations of words and initialize minDistanceMap with Integer.MAX_VALUE
		List<String> twoWordCombinations = generateCombinations(distinctWords);
		twoWordCombinations.stream().forEach(combo -> minDistanceMap.put(combo, Integer.MAX_VALUE));
		
		//Iterate through words[] and populate/update minDistanceMap
		for(int index=0;index<words.length;index++){
			mostRecentPositionMap.put(words[index], index);
			
			for(String key : minDistanceMap.keySet()){
				List<String> keyArray = Arrays.asList(key.split(","));
				if(keyArray.contains(words[index])){
					String[] twoWordCombo = key.split(",");
					String otherWord = twoWordCombo[0].equals(words[index])  ? twoWordCombo[1] : twoWordCombo[0];
					
					if(mostRecentPositionMap.get(otherWord) >= 0 && (index - mostRecentPositionMap.get(otherWord) < minDistanceMap.get(key))){
						minDistanceMap.put(key, index - mostRecentPositionMap.get(otherWord));
					}
				}
			}
			
		}
		
    }

	private static List<String> generateCombinations(List<String> distinctWords){
		List<String> twoWordCombinations = new ArrayList<>();
		int last = distinctWords.size() - 1;
		
		while(last >= 0){
			for(int i=0;i<=last;i++){
				if(!distinctWords.get(i).equals(distinctWords.get(last))){
					twoWordCombinations.add(distinctWords.get(i) + "," + distinctWords.get(last));
				}
				 
			}
			last--;
		}
		
		return twoWordCombinations;
		
	}

}
