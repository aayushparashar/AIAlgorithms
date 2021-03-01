package tabuSearch;

public class CostFunction {
	public static double f(double x, double y){
		return Math.exp(-x*x-y*y)*Math.sin(x);
	}

}
