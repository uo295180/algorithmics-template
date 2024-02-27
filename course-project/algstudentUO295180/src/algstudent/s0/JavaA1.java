package algstudent.s0;



import java.util.LinkedList;
import java.util.List;


public class JavaA1 {
	
	public static void main(String[] args) {
		int n = 10000;
		long time;
		long finnish;
		
		for(int i = 1; i <= 10; i++) {
			time = System.currentTimeMillis();
			
			List<Integer> primes = primeList(n);
			
			finnish = System.currentTimeMillis();
			
			System.out.println("n = " + n + " *** " + "time = " + (int) (finnish-time) + " milliseconds");
			
			n *= 2; 
		}
		
		
		
	}
	
	
	private static boolean isPrime(int n) {
		if(n <= 0) throw new IllegalArgumentException("Invalid parameter <= 0");
		boolean p = true;
		for(int i = 2; i <= n; i++) {
			if(n%i == 0) p = false;
		}
		return p;
	}
	
	public static List<Integer> primeList(int n) {
		List<Integer> primes = new LinkedList<>();
		
		for(int i = 2; i <= n; i++) {
			if(isPrime(i)) {
				primes.add(i);
			}
		
		}
		return primes;

	}
}
