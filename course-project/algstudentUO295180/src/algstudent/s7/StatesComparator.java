package algstudent.s7;

import java.util.Comparator;

public class StatesComparator implements Comparator<State>{

	@Override
	public int compare(State s1, State s2) {
		if(s1.getHeuristic()<s2.getHeuristic())
			return -1;
		else return 1;
	}

}
