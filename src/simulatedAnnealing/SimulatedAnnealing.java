package simulatedAnnealing;

import java.util.Random;

public class SimulatedAnnealing {
	private double currentCoordinateX;
	private double bestCoordinateX;
	private Random rand;
	private double nextCoordinate;

	SimulatedAnnealing() {
		this.rand = new Random();
	}

	private  double getEnergy(double x) {
		return f(x);

	}

	private  double f(double x) {
		return (x - 0.3) * (x - 0.3) * (x - 0.3) - 5 * x + x * x - 2;
	}

	private  double acceptanceProbability(double energy, double newEnergy, double temperature) {
		if (newEnergy < energy)
			return 1;
		return Math.exp((energy - newEnergy) / temperature);
	}

	public void findOptimum() {
		double temperature = Constants.MAX_TEMPERATURE;
		while (temperature > Constants.MIN_TEMPERATURE) {
			nextCoordinate = rand.nextDouble() * (Constants.MAX_X - Constants.MIN_X) + Constants.MIN_X;
			double newEnergy = getEnergy(nextCoordinate);
			double currEnergy = getEnergy(currentCoordinateX);
			if (acceptanceProbability(currEnergy, newEnergy, temperature) > Math.random()) {
				currentCoordinateX = nextCoordinate;
			}
			if (f(currentCoordinateX) < f(bestCoordinateX))
				bestCoordinateX = currentCoordinateX;

			temperature *= 1-Constants.COOLING__RATE;
		}
		System.out.println("BEST COORDNATE x = "+bestCoordinateX +" with f(X) = "+f(bestCoordinateX));
	}
}
