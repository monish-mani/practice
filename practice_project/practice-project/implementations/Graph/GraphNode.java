package Graph;

import java.util.ArrayList;
import java.util.List;


public class GraphNode {
	int id;
	List<GraphNode> adjacencyList;
	State state;
	
	
	public GraphNode(int id){
		this.id = id;
		adjacencyList = new ArrayList<>();
	}
	
	@Override
	public boolean equals(Object g){
		if(g == null) return false;
		
		if(!(g instanceof GraphNode)) return false;
		
		GraphNode otherGraphNode = (GraphNode)g;
		
		return this.id == otherGraphNode.id ? true : false;
	}

	
	@Override
	public int hashCode(){
		return this.id;
	}
	
	public void printAdjacentNodes(){
		adjacencyList.stream()
					 .forEach(node -> System.out.print(node.id + " "));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<GraphNode> getAdjacencyList() {
		return adjacencyList;
	}

	public void setAdjacencyList(List<GraphNode> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	
}
