package Graph;

import java.util.Arrays;

import GraphAlgorithms.BreadthFirstSearch;
import GraphAlgorithms.DepthFirstSearch;

public class GraphMain {
	
	public static void main(String[] args){
		Graph myGraph = new Graph();
		
		GraphNode g1 = new GraphNode(1);
		myGraph.addNode(g1);
		myGraph.addAdjacentNodesToGraphNode(1, Arrays.asList(2,3,4));
		
		GraphNode g5 = new GraphNode(5);
		myGraph.addNode(g5);
		myGraph.addAdjacentNodesToGraphNode(5, Arrays.asList(6,7,8,13));
		
		GraphNode g10 = new GraphNode(10);
		myGraph.addNode(g10);
		myGraph.addAdjacentNodesToGraphNode(10, Arrays.asList(2,7,9));
		
		GraphNode g11 = new GraphNode(11);
		myGraph.addNode(g11);
		myGraph.addAdjacentNodesToGraphNode(11, Arrays.asList(1,5,10));
		
		GraphNode g12 = new GraphNode(12);
		myGraph.addNode(g12);
		myGraph.addAdjacentNodesToGraphNode(12, Arrays.asList(13,14,15));
		
		
		System.out.println("All nodes in the graph:");
		myGraph.printAllGraphNodeIds();
		
		System.out.println("Adjacency list of node 1");
		myGraph.getNodeWithId(1).adjacencyList.stream().forEach(node -> System.out.print(" " + node.id));
		System.out.println();
		
		System.out.println("Adjacency list of node 5");
		myGraph.getNodeWithId(5).adjacencyList.stream().forEach(node -> System.out.print(" " + node.id));
		System.out.println();
		
		System.out.println("Adjacency list of node 10");
		myGraph.getNodeWithId(10).adjacencyList.stream().forEach(node -> System.out.print(" " + node.id));
		System.out.println();
		
		System.out.println("Adjacency list of node 11");
		myGraph.getNodeWithId(11).adjacencyList.stream().forEach(node -> System.out.print(" " + node.id));
		System.out.println();
		
		
		
		
		//BFS
		BreadthFirstSearch bfsObject = new BreadthFirstSearch();
		bfsObject.doBFS(myGraph);
		
		
	}

}
