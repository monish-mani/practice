package Graph;

import java.util.Arrays;

import GraphAlgorithms.DepthFirstSearch;

public class GraphMain2 {
	
	public static void main(String[] args){
		Graph myGraph1 = new Graph();
		
		GraphNode g1 = new GraphNode(1);
		myGraph1.addNode(g1);
		myGraph1.addAdjacentNodesToGraphNode(1, Arrays.asList(2,3));
		myGraph1.addAdjacentNodesToGraphNode(3, Arrays.asList(4,5));

		GraphNode g6 = new GraphNode(6);
		myGraph1.addNode(g6);
		myGraph1.addAdjacentNodesToGraphNode(6, Arrays.asList(7,8,9));
		myGraph1.addAdjacentNodesToGraphNode(8, Arrays.asList(10));
		myGraph1.addAdjacentNodesToGraphNode(10, Arrays.asList(11));
		
		//DFS
		DepthFirstSearch dfsObject = new DepthFirstSearch();
		dfsObject.doDFS(myGraph1);
	}

}
