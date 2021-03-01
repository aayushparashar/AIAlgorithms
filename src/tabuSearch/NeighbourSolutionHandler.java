package tabuSearch;

import java.util.List;

public class NeighbourSolutionHandler {
	State getBestNeighbourSolution(State[][] states, List<State> tabuList, List<State> neighbours) {
		neighbours.removeAll(tabuList);
		if(neighbours.size()==0)
			return states[100][100];
		State bestSolution = neighbours.get(0);
		for(State nbr: neighbours){
			if(nbr.getZ() < bestSolution.getZ())
				bestSolution = nbr;
		}

		return bestSolution;
	}
}
