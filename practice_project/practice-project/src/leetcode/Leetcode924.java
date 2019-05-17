package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode924 {

	public static void main(String[] args) {
		Leetcode924 lc924 = new Leetcode924();
		int[][] graph1 = {
				{1,0,0,0,0,0},
				{0,1,0,0,0,0},
				{0,0,1,0,0,0},
				{0,0,0,1,1,0},
				{0,0,0,1,1,0},
				{0,0,0,0,0,1},
		};
		
		int[] initial1 = {5,1};
		
		System.out.println(lc924.minMalwareSpread(graph1, initial1));
	}

	public int minMalwareSpread(int[][] graph, int[] initial) {
		//Make set
		int[] parent = new int[graph.length];
		for(int i=0;i<parent.length;i++) {
			parent[i] = i;
		}
		
		List<Integer> initialList = new ArrayList<>();
		for(int i=0;i<initial.length;i++) {
			initialList.add(initial[i]);
		}
		
		int[] size = new int[parent.length];
		Arrays.fill(size, 1);
		
		//Process the edges to do union(by rank)
		for(int i=0;i<graph.length;i++) {
			for(int j=0;j<graph[i].length;j++) {
				//If an edge exists, union both the nodes
				if(graph[i][j] == 1) {
					int iParent = findSet(parent,i);
					int jParent = findSet(parent,j);
					
					if(jParent!=iParent) union(parent,size,iParent,jParent);
				}
			}
		}
		
		int[] initiallyInfectedNodesInComponent = new int[parent.length];
		
		for(int i=0;i<initial.length;i++) {
			int root = findSet(parent,initial[i]);
			initiallyInfectedNodesInComponent[root]++;
		}
		
		List<Integer> componentsWithOneInfectedNode = new ArrayList<>();
		//Find components which have only 1 initially infected node.
		for(int i=0;i<initiallyInfectedNodesInComponent.length;i++) {
			if(initiallyInfectedNodesInComponent[i]==1){
				componentsWithOneInfectedNode.add(i);
			}
		}
		
		int maxSize=Integer.MIN_VALUE;
		int minIndex=Integer.MAX_VALUE;
		
		for(int i=0;i<initial.length;i++){
			int root = findSet(parent,initial[i]);
			boolean a = componentsWithOneInfectedNode.contains(root);
			boolean b = size[i] >= maxSize;
			boolean c = minIndex > initial[i];
			if(a&& b && c){
				minIndex = initial[i];
				maxSize = size[i];
			}
		}
		
		//If there are no components which has only 1 initially infected node
		if(maxSize == Integer.MIN_VALUE && minIndex==Integer.MAX_VALUE){
			for(int i=0;i<initial.length;i++){
				if(minIndex > initial[i]){
					minIndex = initial[i];
				}
			}
		}
		
		return minIndex;
	}
	
	private int findSet(int[] parent, int i) {
		while(parent[i]!=i) {
			parent[i] = parent[parent[i]];
			i = parent[i];
		}
		
		return i;
	}
	
	private void union(int[]parent,int[] size,int u,int v) {
		if(size[u] > size[v]) {
			//u is the bigger root, u becomes the parent
			parent[v] = u;
			size[u]+=size[v];
			size[v]=0;
		}else {
			parent[u] = v;
			size[v]+=size[u];
			size[u]=0;
		}
	}

}
