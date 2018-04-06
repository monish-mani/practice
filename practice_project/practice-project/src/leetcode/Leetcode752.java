package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode752 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public int openLock(String[] deadends, String target) {
        if(target == null || target.length() == 0){
            return 0;
        }
        
        //Transferring all teh deadends to a set since I feel I will be accessing them a lot.
        Set<String> deadendsSet = new HashSet<>();
        for(String deadend : deadends){
            deadendsSet.add(deadend);
        }
        
        StringBuilder initialLockConfiguration= new StringBuilder("0000");
        
        int minimumMovesToTarget=Integer.MAX_VALUE;
        //Use stream to get the min number out of them all.
        
        return moveLockPosition(deadendsSet,target,initialLockConfiguration,minimumMovesToTarget,0);
        
         
        
    }
    
    
    public int moveLockPosition(Set<String> deadendSet,String target,StringBuilder currentLockConfiguration,int minimumMovesToTarget,int currentMovesToTarget ){
        if(deadendSet.contains(currentLockConfiguration)){
            return Integer.MAX_VALUE;
        }
        
        currentMovesToTarget++;
        if(currentMovesToTarget <= minimumMovesToTarget){
        	return minimumMovesToTarget;
        }
        
        if(currentLockConfiguration.toString().equals(target)){
        	return currentMovesToTarget;
        }
        
        //moveLockPosition(deadendSet,target,currentLockConfiguration.charAt(0),minimumMovesToTarget,currentMovesToTarget);
        return 0;
    }
    
    public StringBuilder incrementAtPosition(StringBuilder s,int position){
    	s.insert(position, Integer.parseInt(Character.toString(s.charAt(position)))+1);
    	return s;
    }

    public StringBuilder decrementAtPosition(StringBuilder s,int position){
    	s.insert(position, Integer.parseInt(Character.toString(s.charAt(position)))-1);
    	return s;
    }
    
}
