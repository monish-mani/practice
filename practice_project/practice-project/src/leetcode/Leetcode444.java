package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Leetcode444 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode444 lc444 = new Leetcode444();
		
		int[] org1 = {1,2,3};
		int[][] seqArr = {{1,2},{1,3}};
		List<List<Integer>> seqs  = new ArrayList<List<Integer>>();
		
		for(int[] seqa : seqArr) {
			List<Integer> list = Arrays.stream(seqa).boxed().collect(Collectors.toList());
			seqs.add(list);
		}
		
		System.out.println(lc444.sequenceReconstruction(org1, seqs));
		
	}

	public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
		int numOfNodes = getNumOfNodes(seqs);
		List<List<Integer>> adjList = buildAdjList(seqs,numOfNodes);
		
		System.out.println(adjList);
		
		//Find if there is a cycle using dfs also construct leniar ordering using topological sort
		List<Integer> sortedList = new ArrayList<>();
		topologicalSort(adjList,sortedList);
		
		System.out.println("Org list:" + Arrays.toString(org));
		System.out.println("Sorted lsit: " + sortedList);
		
		if(org.length!=sortedList.size()) return false;
		
		for(int i=0;i<org.length;i++) {
			if(org[i]!=sortedList.get(i)) {
				return false;
			}
		}
		
		return true;
		
	}
	
	
	private List<List<Integer>> buildAdjList(List<List<Integer>> seqs,int numOfNodes){
		List<List<Integer>> adjList = new ArrayList<List<Integer>>();
		
		for(int i=0;i<=numOfNodes;i++) {
			adjList.add(new ArrayList<>());
		}
		
		for(List<Integer> seq : seqs) {
			int u=0;
			int v=1;
			
			while(v < seq.size()) {
				adjList.get(seq.get(u)).add(seq.get(v));
				u++;
				v++;
			}
		}
		
		return adjList;
	}
	
	
	//Function to get the max number of nodes.
	private int getNumOfNodes(List<List<Integer>> seqs) {
		int max=0;
		for(List<Integer> seq : seqs) {
			for(Integer i : seq) {
				max = max < i ? i : max;
			}
		}
		
		return max;
	}
	
	
	private void topologicalSort(List<List<Integer>> adjList,List<Integer> sortedList) {
		//0- unvisited, 1 - processing, 2 - visited
		int[] visited = new int[adjList.size()];
		visited[0]=2;
		
		for(int i=1;i<visited.length;i++) {
			if(visited[i] == 0) {
				dfs(i,visited,adjList,sortedList);
			}
		}
	}
	
	private void dfs(int source,int[] visited,List<List<Integer>> adjList,List<Integer> sortedList) {
		visited[source] = 1;
		
		for(Integer neighbor : adjList.get(source)) {
			if(visited[neighbor] == 1) {
				break;
			}else if(visited[neighbor] == 0) {
				dfs(neighbor,visited,adjList,sortedList);
				
			}
		}
		
		visited[source] =2;
		sortedList.add(0, source);
		
	}

}
