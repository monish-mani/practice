package GraphAlgorithms;

import Graph.Graph;
import Graph.GraphNode;
import Graph.State;

public class DepthFirstSearch {
	
	
	public void doDFS(Graph g){
		
		if(g == null || g.getNodes().size() == 0) return;
		
		//Set all nodes as unvisited in the beginning
		for(GraphNode graphNode : g.getNodes()){
			graphNode.setState(State.UNVISITED);
		}
		
		for(GraphNode graphNode : g.getNodes()){
			if(graphNode.getState() == State.UNVISITED){
				dfsForSingleComponent(g,graphNode);
			}
		}
		
	}
	
	
	public void dfsForSingleComponent(Graph g,GraphNode root){
		root.setState(State.PROCESSING);
		System.out.println("Visited node with id " + root.getId());
		for(GraphNode graphNode : root.getAdjacencyList()){
			if(graphNode.getState() == State.UNVISITED){
				dfsForSingleComponent(g,graphNode);
			}
		}
		root.setState(State.VISITED);
	}

}
