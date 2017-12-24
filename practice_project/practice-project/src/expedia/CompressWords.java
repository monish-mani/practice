package expedia;

public class CompressWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input1 = "mmoonniisshh";
		String input2 = "monish";
		
		System.out.println(compressWord(input1));
		System.out.println(compressWord(input2));
		
		
	}
	
	
	public static String compressWord(String word){
		StringBuilder compressedWord = new StringBuilder();
		if(word == null || word.length() ==0){
			return compressedWord.toString();
		}
		
		char currentChar =  word.charAt(0);
		int currentCharCount=1;
		
		int index=1;
		while(index < word.length()){
			if(word.charAt(index) == currentChar){
				currentCharCount++;
			}else{
				compressedWord.append(currentChar);
				compressedWord.append(currentCharCount);
				currentChar = word.charAt(index);
				currentCharCount=1;
			}
			index++;
		}
		compressedWord.append(currentChar);
		compressedWord.append(currentCharCount);
		
		return compressedWord.toString();
	}

}
