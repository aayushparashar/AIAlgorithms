package AI1;
import java.util.ArrayList;
import java.util.List;

public class Node {
	private String name;
	private List<Node> adjacencyList;
	private int depthLevel;

	Node(String name){
		this.name = name;
		adjacencyList = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Node> getAdjacencyList() {
		return adjacencyList;
	}

	public void addVertext(Node adjNode) {
		 adjacencyList.add(adjNode);
	}

	public int getDepthLevel() {
		return depthLevel;
	}

	public void setDepthLevel(int depthLevel) {
		this.depthLevel = depthLevel;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
}
