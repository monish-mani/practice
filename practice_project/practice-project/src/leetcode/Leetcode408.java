package leetcode;

public class Leetcode408 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word = "hi";
		String abbr = "h2";
		System.out.println(validWordAbbreviation(word, abbr));

	}

	public static boolean validWordAbbreviation1(String word, String abbr) {
		
		//a-z --> 97 - 122
		//0-9 --> 48 - 57
		int i=0;
		int j=0;
		
		while(i < word.length() && j < abbr.length()){
			StringBuilder number = new StringBuilder();
			if(abbr.charAt(j) <= 57){
				while(j < abbr.length() && abbr.charAt(j) <= 57){
					number.append(abbr.charAt(j));
					j++;
				}
				int count = Integer.parseInt(number.toString());
				i=i+count;
			}else if(word.charAt(i)!= abbr.charAt(j)){
				return false;
			}
			
			if(i == word.length() || j == word.length()){
				break;
			}
			i++;
			j++;
		}
		//Beacause of the last i++ and j++ they will be 1 more than word and abbr length
		if(i == word.length() && j == abbr.length())
			return true;
		
		return false;

	}

	
	public static boolean validWordAbbreviation(String word,String abbr){
		
		int start1=0;
		int start2=0;
		int end1 = word.length()-1;
		int end2 = abbr.length()-1;
		StringBuffer jumpCount = new StringBuffer();
		
		while(start1 <= end1 && start2 <= end2){
			while((start1 <= end1 && start2 <= end2) && word.charAt(start1) == abbr.charAt(start2)){
				start1++;
				start2++;
				
			}
			
			if (abbr.charAt(start2) <= '0' || abbr.charAt(start2) > '9') {
                return false;
            }
			//2 end scenarios - word and abbr are exactly the same and start1 = end1 && start2 = end2
			//Or you parse abbr(in case number is present at the end) till the end to get the jump count. 
			//In this case start1 = end1 + 1, start2 = end2 + 1
			
			while(start2 <= end2 && abbr.charAt(start2) >= 48 && abbr.charAt(start2) <= 57){
				jumpCount.append(abbr.charAt(start2));
				start2++;
				
			}
			start1 = start1 + Integer.parseInt(jumpCount.toString());
			jumpCount = new StringBuffer();
			
			
		}
		
		return (start1 - end1 == start2 - end2); 
	}
}
