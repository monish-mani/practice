package leetcode;

import java.util.*;

public class Leetcode281 {
	ArrayList<List<Integer>> listOfLists;
    int activeList;
    ArrayList<Integer> listIndexes; //Active index for each list

    public Leetcode281(List<Integer> v1, List<Integer> v2) {
        listOfLists = new ArrayList<List<Integer>>();
        listOfLists.add(v1);
        listOfLists.add(v2);
        
        activeList=0;
        
        listIndexes = new ArrayList<>();
        listIndexes.add(0);
        listIndexes.add(0);
    }

    public int next() {
        if(hasNext()){
            if(listIndexes.get(activeList) < listOfLists.get(activeList).size()){
                int originalIndex = listIndexes.get(activeList);
                int index = originalIndex + 1;
                listIndexes.set(activeList,index);
                activeList = (activeList + 1)%2;
                return listOfLists.get(activeList).get(originalIndex);
            }
            
        }
        return -1;
    }

    public boolean hasNext() {
        return (listIndexes.get(0) < listOfLists.get(0).size() || listIndexes.get(1) < listOfLists.get(1).size());
    }
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
