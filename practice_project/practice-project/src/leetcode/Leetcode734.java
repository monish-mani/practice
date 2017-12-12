package leetcode;

public class Leetcode734 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] words1={"great"};
		String[] words2={"great"};
		String[][] pairs = 	{};
				
		System.out.println(areSentencesSimilar(words1, words2, pairs));
						

	}
	
	public static boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if(words1 == null && words2 == null){
            return true;
        }
        
        if(words1.length == 0 && words2.length==0){
            return true;
        }
        
        if(words1.length!=words2.length){
            return false;
        }
        
        int i=0;
        int row = pairs.length;
        boolean pairFound=false;
        
        while(i < words1.length){
            if(words1[i].equals(words2[i])){
                i++;
            }else{
                //Compare from pairs
                for(int j=0;j<row;j++){
                    if((pairs[j][0].equals(words1[i]) && pairs[j][1].equals(words2[i])) || ((pairs[j][0].equals(words2[i]) && pairs[j][1].equals(words1[i])))){
                        pairFound=true;
                        break;
                    }
                }
                if(pairFound){
                    i++;
                    pairFound=false;
                }else{
                    return false;
                }
            }
        }
        
        return true;
    }

}
