package AStarSearch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SearchAlgorithm {
	private Node[][] searchSpace;
	private Node startNode;
	private Node finalNode;

	List<Node> closedSet;
	PriorityQueue<Node> openSet;

	public SearchAlgorithm() {
		closedSet = new ArrayList<>();
		openSet = new PriorityQueue<>(new Comparator<Node>() {
			public int compare(Node a, Node b) {
				return a.getF() - b.getF();
			}
		});
		initializeSearchSpace();
	}

	public void initializeSearchSpace() {
		searchSpace = new Node[Constant.num_rows][Constant.num_cols];
		for (int i = 0; i < Constant.num_rows; i++) {
			for (int j = 0; j < Constant.num_cols; j++) {
				Node nn = new Node(i, j);
				searchSpace[i][j] = nn;
			}
		}

		searchSpace[1][7].setBlock(true);
		searchSpace[2][3].setBlock(true);
		searchSpace[2][4].setBlock(true);
		searchSpace[2][5].setBlock(true);
		searchSpace[2][6].setBlock(true);
		searchSpace[2][7].setBlock(true);

		this.startNode = searchSpace[3][3];
		this.finalNode = searchSpace[1][6];
	}

	public void search() {
		startNode.setG(0);
		startNode.setH(manhattenDistance(startNode, finalNode));
		openSet.add(startNode);
		while (!openSet.isEmpty()) {
			Node curr = openSet.poll();

			System.out.println(curr+": Predecessor "+curr.getPredecessor());
			if (curr.equals(finalNode)) {
				return;
			}
			closedSet.add(curr);
			openSet.remove(curr);

			for (Node v : getAllNeighbours(curr)) {
				if (closedSet.contains(v))
					continue;
				if (!openSet.contains(v))
					openSet.add(v);
				v.setPredecessor(curr);

			}
		}
	}

	public List<Node> getAllNeighbours(Node node) {
		int r = node.getRow();
		int c = node.getCol();
		List<Node> arr = new ArrayList<>();

		if (r - 1 >= 0 && !searchSpace[r - 1][c].isBlock()) {
			searchSpace[r - 1][c].setG(node.getG() + Constant.vertical_cost);
			searchSpace[r - 1][c].setH(manhattenDistance(searchSpace[r - 1][c], finalNode));
			arr.add(searchSpace[r - 1][c]);
		}
		if (r + 1 < Constant.num_rows && !searchSpace[r + 1][c].isBlock()) {
			searchSpace[r + 1][c].setG(node.getG() + Constant.vertical_cost);
			searchSpace[r + 1][c].setH(manhattenDistance(searchSpace[r + 1][c], finalNode));
			arr.add(searchSpace[r + 1][c]);
		}
		if (c - 1 >= 0 && !searchSpace[r][c - 1].isBlock()) {
			searchSpace[r][c - 1].setG(node.getG() + Constant.vertical_cost);
			searchSpace[r][c - 1].setH(manhattenDistance(searchSpace[r][c - 1], finalNode));
			arr.add(searchSpace[r][c - 1]);
		}
		if (c + 1 < Constant.num_cols && !searchSpace[r][c + 1].isBlock()) {
			searchSpace[r][c + 1].setG(node.getG() + Constant.vertical_cost);
			searchSpace[r][c + 1].setH(manhattenDistance(searchSpace[r][c + 1], finalNode));
			arr.add(searchSpace[r][c + 1]);
		}

		return arr;
	}

	public int manhattenDistance(Node a, Node b) {
		return (Math.abs(a.getRow() - b.getRow()) + Math.abs(a.getCol() - b.getCol())) * 10;
	}

	public void showPath() {

		System.out.println("FINAL PATHH");
		Node nn = finalNode;
		while (nn != null) {
			System.out.println(nn);
			nn = nn.getPredecessor();
		}


	}

}
