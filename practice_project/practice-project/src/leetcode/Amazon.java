package leetcode;
import java.util.*;


public class Amazon {

	public static void main(String[] args) {
		List<String> logLines = new ArrayList<String>();
		//logLines.add("a1 9 2 3 1");
		logLines.add("a8 act car");
		logLines.add("a8 act car zar");
		//logLines.add("zo4 4 7");
		//logLines.add("a8 act car nar");
		
		System.out.println(reorderLines(4,logLines));
		//System.out.println("Greater Identifer: " + compareStringsLexicographically("g1","a8"));
	}

	public static List<String> reorderLines(int logFileSize, List<String> logLines) {
		// WRITE YOUR CODE HERE
		List<String> stringLogLines = new ArrayList<>();
		List<String> numLogLines = new ArrayList<>();

		for (String logLine : logLines) {
			if (isNumberLine(logLine)) {
				numLogLines.add(logLine);
			} else {
				stringLogLines.add(logLine);
			}
		}
		
		Collections.sort(stringLogLines,new Comparator<String>(){
			public int compare(String line1,String line2){
				String[] line1Parts = line1.split(" ");
				String[] line2Parts = line2.split(" ");
				
				int i=1,j=1;
				while(i < line1Parts.length && j < line2Parts.length){
					int greaterString = compareStringsLexicographically(line1Parts[i],line2Parts[j]);
					if(greaterString == 0){
						i++;
						j++;
					}else{
						return greaterString == -1 ? -1 : 1;
					}
				}
				
				if(i == line1Parts.length && j == line2Parts.length){
					int greaterIdentifier = compareStringsLexicographically(line1Parts[0],line2Parts[0]);
					return greaterIdentifier == 1 ? 1 : -1;
				}
				
				return i == line1Parts.length ? -1 : 1;
			}
		});

		stringLogLines.addAll(numLogLines);
		
		return stringLogLines;
	}
	// METHOD SIGNATURE ENDS

	// 1 - first word is greater
	// 2 - second word greater
	// 0 - both words are same
	private static int compareStringsLexicographically(String s1, String s2) {
		if (s1 == null && s2 == null || s1.length() == 0 && s2.length() == 0)
			return 0;

		int index1 = 0;
		int index2 = 0;

		while (index1 < s1.length() && index2 < s2.length()) {
			if (s1.charAt(index1) == s2.charAt(index2)) {
				index1++;
				index2++;
			} else {
				return (int) s1.charAt(index1) > (int) s2.charAt(index2) ? 1 : -1;
			}
		}

		if(index1 == s1.length() && index2 == s2.length()) return 0;
		
		return index1 == s1.length() ? -1 : 1;
	}

	private static boolean isNumberLine(String logLine) {
		int index = 0;

		while (index < logLine.length()) {
			if (logLine.charAt(index) == ' ') {
				break;
			}
			index++;
		}

		index = index + 1; // Pointing to first character after log line
							// identifier and spce

		return logLine.charAt(index) >= '0' && logLine.charAt(index) <= '9';

	}

}
