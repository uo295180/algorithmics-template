package algstudent.s2;

public class QuicksortTimes {
	static int[] v;

	public static void main(String arg[]) {
		long t1, t2;
		String opcion = arg[0];

		for (int n = 0; n <= 6; n++) {
			int size =(int) (250000*Math.pow(2, n)); 
			v = new int[size];
			
			if (opcion.compareTo("ordered") == 0)
				Vector.sorted(v);
			else if (opcion.compareTo("reverse") == 0)
				Vector.reverseSorted(v);
			else
				Vector.randomSorted(v);

			t1 = System.currentTimeMillis();

			Quicksort.quicksort(v);

			t2 = System.currentTimeMillis();

			System.out.println(size + "\t" + (t2 - t1));
		}
	}
}
