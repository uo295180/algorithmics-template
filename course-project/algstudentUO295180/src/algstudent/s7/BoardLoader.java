package algstudent.s7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class BoardLoader {
	
	public static String[][] loadData(String file) {
		BufferedReader reader = null;
		String text;
		int size;
		String[][] data = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			text = reader.readLine();
			size = Integer.valueOf(text);
			data = new String[size*2+1][size*2+1];
			int counter = 0;
			while (reader.ready()) {
				String[] parts = reader.readLine().split(" ");
				for(int i  = 0; i< parts.length; i++) {
					data[counter][i] = parts[i];
				}
				counter++;
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
		return data;
	}
}
