package tabuSearch;

import java.util.ArrayList;
import java.util.List;

public class State {
	private double x;
	private double y;
	private double z;
	List<State> neighbours;
	State(double x, double y){
		this.x = x;
		this.y = y;
		this.z = CostFunction.f(x,y);
		neighbours = new ArrayList<>();
	}
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}
	public List<State> getNeighbours() {
		return neighbours;
	}
	public void addNeighbour(State neighbour) {
		this.neighbours.add(neighbour);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return z+"";
	}


}
