package AStarSearch;

public class Node {

	private int g;
	private int h;
	private Node predecessor;
	private boolean isBlock;
	private int row;
	private int col;

	Node(int r, int c) {
		this.row = r;
		this.col = c;
	}

	public int getF() {
		return g + h;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public Node getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(Node predecessor) {
		this.predecessor = predecessor;
	}

	public boolean isBlock() {
		return isBlock;
	}

	public void setBlock(boolean isBlock) {
		this.isBlock = isBlock;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Node (" + row + ":" + col + ")" + "g = " + g + " h= " + h + ":: f = " + getF();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Node node = (Node)obj;
		return node.row == row && node.col == col;
	}

}
