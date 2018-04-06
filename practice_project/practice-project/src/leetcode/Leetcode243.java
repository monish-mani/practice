package leetcode;

public class Leetcode243 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		String word1="coding";
		String word2="makes";
		
		System.out.println(shortestDistance(words, word1, word2));
	}
	
	
	public static int shortestDistance(String[] words, String word1, String word2) {
        // 0 - word1 && 1 - word2
        int[] lastPosition = new int[2];
        //Points to the index position of most recently occured word(among word1 and word2)
        int lastWordIndex=-1;
        
        int minDistance=Integer.MAX_VALUE;
        
        for(int index=0;index<words.length;index++){
            if(words[index].equals(word1)){
                if(lastWordIndex == 1 && (index - lastPosition[1]) < minDistance){
                    minDistance = index - lastPosition[1];    
                }
                lastPosition[0] = index;
                lastWordIndex=0;
            }else if(words[index].equals(word2)){
                if(lastWordIndex == 0 && (index - lastPosition[0] < minDistance)){
                    minDistance = index - lastPosition[0];
                }
                lastPosition[1] = index;
                lastWordIndex=1;
            }
        }
        
        return minDistance;
    }

}
