package GraphAlgorithms;

import java.util.LinkedList;
import java.util.Queue;

import Graph.Graph;
import Graph.GraphNode;
import Graph.State;

public class BreadthFirstSearch {
	
	public void doBFS(Graph g){
		if(g == null || g.getNodes().size() == 0) return;
	
		//Set all nodes as unvisited in the beginning
		for(GraphNode graphNode : g.getNodes()){
			graphNode.setState(State.UNVISITED);
		}
		
		/*
		 * BFS covers all nodes in 1 component. But if there are multiple components,
		 * we have to check each node for visited similar to DFS.
		 */
		for(GraphNode graphNode : g.getNodes()){
			if(graphNode.getState() == State.UNVISITED){
				bfsForSingleComponent(g,graphNode);
			}
		}
		
	}
	
	
	private void bfsForSingleComponent(Graph g,GraphNode root){
		Queue<Integer> bfsQueue = new LinkedList<>();
		
		bfsQueue.add(root.getId());
		
		while(!bfsQueue.isEmpty()){
			GraphNode processingNode = g.getNodeWithId(bfsQueue.poll());
			processingNode.setState(State.PROCESSING);
			
			for(GraphNode adjacentNode : processingNode.getAdjacencyList()){
				
				
				if(adjacentNode.getState() == State.UNVISITED){
					bfsQueue.add(adjacentNode.getId());
				}
			}
			
			processingNode.setState(State.VISITED);
			System.out.println("Visited node with id " + processingNode.getId());
			
		}
	}

}
