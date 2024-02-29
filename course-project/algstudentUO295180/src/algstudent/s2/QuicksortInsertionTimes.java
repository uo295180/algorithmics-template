package algstudent.s2;

public class QuicksortInsertionTimes {
	static int[] v;

	public static void main(String arg[]) {
		long t1, t2;
		int n = 16000000; 

//		v = new int[] {30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9 ,8 ,7, 6, 5, 4, 3, 2, 1, 0};
//		t1 = System.currentTimeMillis();
//		QuicksortInsertion.quicksort(v, 5);
//		t2 = System.currentTimeMillis();
//		System.out.println(n + "\t" + (t2 - t1));
		
		
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
		System.out.println(n + "\t" + (t2 - t1) + "\tk = " + k);
		
		k = 10;
		v = new int[n];
		Vector.randomSorted(v);
		t1 = System.currentTimeMillis();
		QuicksortInsertion.quicksort(v, k);
		t2 = System.currentTimeMillis();
		System.out.println(n + "\t" + (t2 - t1) + "\tk = " + k);
		
		k = 20;
		v = new int[n];
		Vector.randomSorted(v);
		t1 = System.currentTimeMillis();
		QuicksortInsertion.quicksort(v, k);
		t2 = System.currentTimeMillis();
		System.out.println(n + "\t" + (t2 - t1) + "\tk = " + k);
		
		k = 30;
		v = new int[n];
		Vector.randomSorted(v);
		t1 = System.currentTimeMillis();
		QuicksortInsertion.quicksort(v, k);
		t2 = System.currentTimeMillis();
		System.out.println(n + "\t" + (t2 - t1) + "\tk = " + k);
		
		k = 40;
		v = new int[n];
		Vector.randomSorted(v);
		t1 = System.currentTimeMillis();
		QuicksortInsertion.quicksort(v, k);
		t2 = System.currentTimeMillis();
		System.out.println(n + "\t" + (t2 - t1) + "\tk = " + k);
		
		k = 50;
		v = new int[n];
		Vector.randomSorted(v);
		t1 = System.currentTimeMillis();
		QuicksortInsertion.quicksort(v, k);
		t2 = System.currentTimeMillis();
		System.out.println(n + "\t" + (t2 - t1) + "\tk = " + k);
		
		k = 100;
		v = new int[n];
		Vector.randomSorted(v);
		t1 = System.currentTimeMillis();
		QuicksortInsertion.quicksort(v, k);
		t2 = System.currentTimeMillis();
		System.out.println(n + "\t" + (t2 - t1) + "\tk = " + k);
		
		k = 200;
		v = new int[n];
		Vector.randomSorted(v);
		t1 = System.currentTimeMillis();
		QuicksortInsertion.quicksort(v, k);
		t2 = System.currentTimeMillis();
		System.out.println(n + "\t" + (t2 - t1) + "\tk = " + k);
		
		k = 500;
		v = new int[n];
		Vector.randomSorted(v);
		t1 = System.currentTimeMillis();
		QuicksortInsertion.quicksort(v, k);
		t2 = System.currentTimeMillis();
		System.out.println(n + "\t" + (t2 - t1) + "\tk = " + k);
		
		k = 1000;
		v = new int[n];
		Vector.randomSorted(v);
		t1 = System.currentTimeMillis();
		QuicksortInsertion.quicksort(v, k);
		t2 = System.currentTimeMillis();
		System.out.println(n + "\t" + (t2 - t1) + "\tk = " + k);
		
	}
}
