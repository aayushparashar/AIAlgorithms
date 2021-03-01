package tspSA;

public class City {
	private String name;
	private int x;
	private int y;

	City(String name) {
		this.name = name;
		x = (int) (Math.random() * 100);
		this.y = (int) (Math.random() * 100);
	}

	City(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;

	}

	public double distanceTo(City city) {
		int xDist = Math.abs(this.x - city.x);
		int yDist = Math.abs(this.y - city.y);
		return Math.sqrt(xDist * xDist + yDist * yDist);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "City " + name + " (" + x + "-" + y + ")";
	}
}
