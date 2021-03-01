package tspSA;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++)
			Respository.addCity(new City("" + i));
		SimulatedAnnealing annealing = new SimulatedAnnealing();
		annealing.simulation();

	}

}
