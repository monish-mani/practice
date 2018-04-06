package leetcode;
import java.math.*;
import java.util.Arrays;

public class Leetcode544 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findContestMatch(8));;
	}
	
	public static String findContestMatch(int n){
		String[] result = new String[n];
		
		//Populate initial arrangement
		for(int i=0;i<n;i++){
			Integer team = new Integer(i+1);
			result[i] = team.toString();
		}
		
		while(n > 1){
			for(int i=0;i<n/2;i++){
				result[i] = "(" + result[i] + "," + result[n-i-1] + ")";
			}
			n=n/2;
		}
		
		
		return result[0];
	}
	
	
	
	public static String findContestMatchStupid(int n) {
        //Calculate total num of rounds
        int numOfRounds=0;
        int numOfTeams=n;
        while(numOfTeams > 0){
            if((numOfTeams & 1) == 0) numOfRounds++;
            numOfTeams = numOfTeams>>1;
        }
        
        int[] teamArrangement = new int[n];
        
        //Populate initial arrangement
        for(int i=0;i<n;i++){
            teamArrangement[i] = i+1;
        }
        
        //int currentRound=1;
        int[] nextTeamArrangement = new int[n];
        
        for(int currentRound=0;currentRound<numOfRounds;currentRound++){
            matchTeams(teamArrangement,currentRound,nextTeamArrangement); // from 0 - 2
            System.out.println(Arrays.toString(nextTeamArrangement));
            teamArrangement = nextTeamArrangement;
            nextTeamArrangement = new int[n];
        }
        
        //System.out.println(Arrays.toString(teamArrangement));
        return null;
    }
		
	
	
    private static void matchTeams(int[] teamArrangement, int currentRound,int[] nextTeamArrangement){
        int numOfTeamToShift = (int) Math.pow(2,currentRound);
        
        int start =0;
        int end =teamArrangement.length;
        
        int index=0;
        while(start < end){
            for(int i=start;i<start+numOfTeamToShift;i++){
                nextTeamArrangement[index++] = teamArrangement[i];
            }
            start = start + numOfTeamToShift;
            for(int i=end - numOfTeamToShift;i<end;i++){
                nextTeamArrangement[index++] = teamArrangement[i];
            }
            end = end - numOfTeamToShift;
        }

    }

}
