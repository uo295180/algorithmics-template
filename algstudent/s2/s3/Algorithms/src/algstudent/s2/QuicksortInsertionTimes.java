package algstudent.s2;

public class QuicksortInsertionTimes {
	static int[] v;

	public static void main(String arg[]) {
		long t1, t2;
		int n = 16000000; 

		v = new int[n];
		Vector.randomSorted(v);
		t1 = System.currentTimeMillis();
		QuicksortInsertion.quicksort(v, 0);
		t2 = System.currentTimeMillis();
		System.out.println(n + "\t" + (t2 - t1));
		
		int k = 5;
		v = new int[n];
		Vector.randomSorted(v);
		t1 = System.currentTimeMillis();
		QuicksortInsertion.quicksort(v, k);
		t2 = System.currentTimeMillis();
		System.out.println(n + "\t" + (t2 - t1) + "k = " + k);
		
		k = 10;
		v = new int[n];
		Vector.randomSorted(v);
		t1 = System.currentTimeMillis();
		QuicksortInsertion.quicksort(v, k);
		t2 = System.currentTimeMillis();
		System.out.println(n + "\t" + (t2 - t1) + "k = " + k);
		
		k = 20;
		v = new int[n];
		Vector.randomSorted(v);
		t1 = System.currentTimeMillis();
		QuicksortInsertion.quicksort(v, k);
		t2 = System.currentTimeMillis();
		System.out.println(n + "\t" + (t2 - t1) + "k = " + k);
		
		k = 30;
		v = new int[n];
		Vector.randomSorted(v);
		t1 = System.currentTimeMillis();
		QuicksortInsertion.quicksort(v, k);
		t2 = System.currentTimeMillis();
		System.out.println(n + "\t" + (t2 - t1) + "k = " + k);
		
		k = 40;
		v = new int[n];
		Vector.randomSorted(v);
		t1 = System.currentTimeMillis();
		QuicksortInsertion.quicksort(v, k);
		t2 = System.currentTimeMillis();
		System.out.println(n + "\t" + (t2 - t1) + "k = " + k);
		
		k = 50;
		v = new int[n];
		Vector.randomSorted(v);
		t1 = System.currentTimeMillis();
		QuicksortInsertion.quicksort(v, k);
		t2 = System.currentTimeMillis();
		System.out.println(n + "\t" + (t2 - t1) + "k = " + k);
		
		k = 100;
		v = new int[n];
		Vector.randomSorted(v);
		t1 = System.currentTimeMillis();
		QuicksortInsertion.quicksort(v, k);
		t2 = System.currentTimeMillis();
		System.out.println(n + "\t" + (t2 - t1) + "k = " + k);
		
		k = 200;
		v = new int[n];
		Vector.randomSorted(v);
		t1 = System.currentTimeMillis();
		QuicksortInsertion.quicksort(v, k);
		t2 = System.currentTimeMillis();
		System.out.println(n + "\t" + (t2 - t1) + "k = " + k);
		
		k = 500;
		v = new int[n];
		Vector.randomSorted(v);
		t1 = System.currentTimeMillis();
		QuicksortInsertion.quicksort(v, k);
		t2 = System.currentTimeMillis();
		System.out.println(n + "\t" + (t2 - t1) + "k = " + k);
		
		k = 1000;
		v = new int[n];
		Vector.randomSorted(v);
		t1 = System.currentTimeMillis();
		QuicksortInsertion.quicksort(v, k);
		t2 = System.currentTimeMillis();
		System.out.println(n + "\t" + (t2 - t1) + "k = " + k);
		
	}
}
