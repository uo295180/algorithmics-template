package algstudent.s7;

public class State {
	int[][] matrixStatus;
	int nextIndex;
	
	public State(int[][] state, int nextIndex) {
		matrixStatus = copyOf(state);
		this.nextIndex = nextIndex;
	}
	
	public int getHeuristic() {
		int heuristic = 0;
		for(int i = 0; i < matrixStatus.length; i++) {
			for(int j = 0;  j < matrixStatus.length; j++) {
				if(matrixStatus[i][j] == -1) heuristic++;
			}
		}
		return heuristic;
	}
	
	private int[][] copyOf(int[][] values){
		int[][] copy = new int[values.length][values.length];
		
		for(int i = 0; i < values.length; i++) {
			for(int j = 0; j < values.length; j++) {
				copy[i][j] = values[i][j];
			}
		}
		return copy;
	}

	public int[][] getData() {
		return matrixStatus;
	}

	public int getIndex() {
		return nextIndex;
	}
}
