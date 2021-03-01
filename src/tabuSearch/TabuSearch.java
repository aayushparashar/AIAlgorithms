package tabuSearch;

public class TabuSearch {
	NeighbourSolutionHandler nbh;
	TabuList tabuList;
	State[][] states;

	TabuSearch(State[][] arr) {
		states = arr;
		nbh = new NeighbourSolutionHandler();
		tabuList = new TabuList();
	}

	public State solve(State initial) {
		State bestSolution = initial;
		State currentState = initial;
		for (int i = 0; i < Constants.NUM_ITERATIONS; i++) {
			State nbr = nbh.getBestNeighbourSolution(states, tabuList.getTabuList(), currentState.getNeighbours());
			if (nbr.getZ() < bestSolution.getZ())
				bestSolution = nbr;

			tabuList.add(currentState);
			currentState = nbr;
		}
		return bestSolution;
	}
}
