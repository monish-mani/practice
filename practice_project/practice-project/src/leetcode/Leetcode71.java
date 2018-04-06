package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Leetcode71 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path1 = "/a/./b/../../c/";
		String path2 = "/c";
		String path3 = "/./././";
		String path4 = "/home/../../..";
		String path5 = "/..";
		
		System.out.println(simplifyPath(path1));
		System.out.println(simplifyPath(path2));
		System.out.println(simplifyPath(path3));
		System.out.println(simplifyPath(path4));
		System.out.println(simplifyPath(path5));
		
		
		
	}
	
	
	public static String simplifyPath(String path) {
		LinkedList<String> directoryList = new LinkedList<>();
		String[] parts = path.split("/");
		
		for(String s : parts){
			if(s.length() == 0){
        		continue;
        	}
			
			if(s.equals("..")){
				if(directoryList.size() > 0){
					directoryList.pollLast();
				}
				
			}else if(!s.equals(".")){ 
				directoryList.add(s);
			}
		}
		
		
		StringBuilder result = new StringBuilder();
		
		for(String directory : directoryList){
			result.append("/");
			result.append(directory);
			
		}
		
		//Append default '/' at the end
		if(!(result.length() > 0)){
			result.append("/");
		}
		
		
		return result.toString();
	}

}
