package amazon;

import java.util.ArrayList;
import java.util.List;

public class OnlineTest2 {
	public static void main(String[] args){
		List<Character> inputList = null;
		
	}
	
	
	private static List<Integer> lengthEachScene(List<Character> inputList){
		List<Integer> result = new ArrayList<>();
		
		int[] map = new int[26];
		for(int i=0;i<inputList.size();i++){
			char c = inputList.get(i);
			map[c-'a'] = i;
		}
		
		int max=0;
		int start=0;
		for(int i=0;i<inputList.size();i++){
			char c = inputList.get(i);
			max = Math.max(max, map[c-'a']);
			if(max == i){
				System.out.println(max);
				result.add(max - start + 1);
				start = i-1;
			}
		}
		return result;
		
	}
	
	

}
