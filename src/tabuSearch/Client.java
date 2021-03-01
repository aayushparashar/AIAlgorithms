package tabuSearch;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		State[][] states = new State[Constants.NUM_VALUES][Constants.NUM_VALUES];
		int row =0;
		int col = 0;
		for(double i = -10; i<9.9; i+=0.1, row++, col =0 ){
			for(double j = -10; j<9.9 ; j+=0.1, col++)
				states[row][col] = new State(i, j);
		}

		for(int i =0; i<states.length; i++){
			for(int j =0; j<states.length; j++){
				try{
					states[i][j].addNeighbour(states[i-1][j]);
				}catch(Exception e){

				}
				try{
					states[i][j].addNeighbour(states[i+1][j]);
				}catch(Exception e){

				}	try{
					states[i][j].addNeighbour(states[i][j-1]);
				}catch(Exception e){

				}	try{
					states[i][j].addNeighbour(states[i][j+1]);
				}catch(Exception e){

				}
			}

		}

		TabuSearch search = new TabuSearch(states);
		State ans = search.solve(states[100][100]);
		System.out.println(ans);

	}

}
