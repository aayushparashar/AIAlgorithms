package tspSA;

import java.util.ArrayList;
import java.util.List;

public class SimulatedAnnealing {
	private SingleTour bestTour = new SingleTour();
	private SingleTour currTour = new SingleTour();

	public void simulation() {
		currTour.generateIndividual();
		bestTour = new SingleTour(currTour.getTour());
		double temperature = 10000;
		double cooling_rate = 0.003;
		System.out.println("Intial Tour:");
		System.out.println(currTour);
		while (temperature > 1) {
			SingleTour newTour = new SingleTour(currTour.getTour());
			newTour.swapRandomCities();
			double currEnergy = currTour.getDistance();
			double newEnergy = newTour.getDistance();
			if (acceptanceProbability(currEnergy, newEnergy, temperature) > Math.random())
				currTour = newTour;
			if (currTour.getDistance() < bestTour.getDistance())
				bestTour = new SingleTour(currTour.getTour());
			temperature *= 1 - cooling_rate;
		}
		System.out.println("Best Tour: ");
		System.out.println(bestTour);

	}

	private double acceptanceProbability(double energy, double newEnergy, double temperature) {
		if (newEnergy < energy)
			return 1;
		return Math.exp((energy - newEnergy) / temperature);
	}

}
