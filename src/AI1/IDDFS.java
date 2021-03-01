package AI1;

import java.util.Stack;

public class IDDFS {
	private Node targetNode;
	private volatile boolean isTargetFound;
	IDDFS(Node targetNode){
		this.targetNode = targetNode;
		isTargetFound = false;
	}
	void search(Node rootVertex){
		int depth = 0;
		while(!isTargetFound){
			DFS(rootVertex, depth);
			depth++;
		}
	}
	void DFS(Node rootVertex, int depthLevel){
		rootVertex.setDepthLevel(0);
		Stack<Node> stack = new Stack<>();
		stack.add(rootVertex);
		while(!stack.isEmpty()){
			Node nn = stack.pop();
			System.out.print(nn+" ");

			if(nn.getName().equals(targetNode.getName())){
				System.out.println("NODE FOUND");
				isTargetFound = true;
				return;
			}
			if(nn.getDepthLevel() >= depthLevel)
				continue;
			for(Node n: nn.getAdjacencyList()){
				n.setDepthLevel(nn.getDepthLevel()+1);
				stack.add(n);
			}
		}
		System.out.println();
	}
}
