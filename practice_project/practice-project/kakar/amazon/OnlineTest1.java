package amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OnlineTest1 {
	
	public static void main(String[] args){
		String s ="mmonnnishhmmonnnishh";
		System.err.println(subStringsLessKDist(s,4));
	}
	
	
	
	public static List<String> subStringsLessKDist(String inputString,int num){
		Set<String> result = new HashSet<>();
		List<String> resultList = new ArrayList<>(result);
		if(inputString == null || inputString.length() < num){
			return resultList;
		}
		
		for(int i=0;i<=inputString.length()-num;i++){
			String str = inputString.substring(i, i+num);
			
			if(isValid(str)){
				result.add(str);
			}
		}
		
		
		resultList = new ArrayList<>(result);
		return resultList;
	}
	

	
	
	private static boolean isValid(String str){
		Map<Character,Integer> map = new HashMap<>();
		boolean countTwo=false;
		Character cTwo = null;
		for(char c : str.toCharArray()){
			Integer count = map.getOrDefault(c,0);
			if(count > 1){
				return false;
			}
			if((count +1) == 2){
				if(cTwo!=null){
					return false;
				}
				cTwo = c;
				countTwo = true;
			}
			map.put(c, count+1);
		}
		return countTwo;
	}

}
