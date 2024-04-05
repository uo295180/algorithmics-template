package labs.examples.backtracking.passwords;

import java.util.List;
import org.junit.Test;

public class PasswordGeneratorTest {
	@Test
	public void test() {
		int numberOfTotalCharacters = 100;
		int numberOfNonLettersEnds = 6;
		int numberOfPasswords = 50;
		String consonantPairsPath = "src/main/java/labs/examples/backtracking/passwords/consonant_pairs.txt"; 
		
		PasswordGenerator generator = new PasswordGenerator(
				numberOfTotalCharacters,
				numberOfNonLettersEnds,
				numberOfPasswords,
				consonantPairsPath);
	
		generator.generate();
		List<String> passwords = generator.getPasswords();	
		
		for (int i = 0; i < numberOfPasswords; i++) {			
			String password = passwords.get(i);
			System.out.println((i+1) + ": " + password);
		}
	}
	
}
