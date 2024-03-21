package algstudent.s5;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PatternMatchingTest {
	String text;
	List<String> patterns;
	List<Boolean> expectedResults;
	
	@Test
	public void test1() {
		loadData("src/algstudent/s5/test01.txt");		
		PatternMatching patternMatching = new PatternMatching(text);		
		for (int i = 0; i < patterns.size(); i++) {			
			patternMatching.checkPattern(patterns.get(i));
			patternMatching.printsTable();
			assertEquals(expectedResults.get(i), patternMatching.checkPattern(patterns.get(i)));
				
		}
	}
	
	@Test
	public void test2() {
		loadData("src/algstudent/s5/test02.txt");		
		PatternMatching patternMatching = new PatternMatching(text);		
		for (int i = 0; i < patterns.size(); i++) {			
			assertEquals(expectedResults.get(i), patternMatching.checkPattern(patterns.get(i)));
			patternMatching.printsTable();	
		}
	}
	
	@Test
	public void test3() {
		loadData("src/algstudent/s5/test03.txt");		
		PatternMatching patternMatching = new PatternMatching(text);		
		for (int i = 0; i < patterns.size(); i++) {			
			assertEquals(expectedResults.get(i), patternMatching.checkPattern(patterns.get(i)));
			patternMatching.printsTable();	
		}
	}

	private void loadData(String file) {
		BufferedReader reader = null;
		this.patterns = new ArrayList<String>();
		this.expectedResults = new ArrayList<Boolean>();	

		try {
			reader = new BufferedReader(new FileReader(file));
			this.text = reader.readLine(); 	
			while (reader.ready()) {
				String[] parts = reader.readLine().split(" ");
				this.patterns.add(parts[0]);
				this.expectedResults.add(Boolean.valueOf(parts[1]));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
