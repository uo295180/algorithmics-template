package algstudent.s5;

public class PatternMatching {
	
	String targetString;
	int targetLength;
	String compareString;
	int compareLength;
	
	char[] target;
	char[] compare;
	
	boolean[][] comparisonTable;
	
	
	public PatternMatching(String targetText) {
		targetString = targetText;
		target = targetText.toCharArray();
		targetLength = target.length;
	}

	public boolean checkPattern(String compareText) {
		compareString = compareText;
		compareLength = compareText.length();
		compare = compareString.toCharArray();
		comparisonTable = new boolean[targetLength+1][compareLength+1];	
		comparisonTable[0][0] = true;
		
		// If the compareText is empty, the program will not 
		// enter the loop. Therefore, the only way for the program
		// to return true is if the other text is empty, because
		// the element at index (0,0) is true also 
		for(int i = 1; i<=compareLength; i++) {
			for(int j = 1; j <=targetLength; j++) {
				if(target[j-1]==compare[i-1]) {
					if(comparisonTable[j-1][i-1]) comparisonTable[j][i] = true;
				}
				else if(compare[i-1]=='?') {
					// Check or left or diag-left
					if(comparisonTable[j-1][i-1]||comparisonTable[j][i-1]) comparisonTable[j][i] = true; 
				}
				else if(compare[i-1]=='*') {
					// Check or left, diag-left adn top
					if(comparisonTable[j-1][i-1]||comparisonTable[j-1][i]||comparisonTable[j][i-1]) comparisonTable[j][i] = true;
				}
			}
		}
		return comparisonTable[targetLength][compareLength];
	}
	
	public void printsTable() {
		for(int i = 0; i<=targetLength+1; i++) {
			System.out.println();
			for(int j = 0; j<=compareLength+1;j++) {
				if(i == 0) {
					if(j < 2)	System.out.print("   ");
					else System.out.print(" " + compare[j-2] + " ");
				}
				else if(i == 1) {
					if(j == 0) System.out.print("   ");
					else if(comparisonTable[0][j-1]) System.out.print(" T ");
					else System.out.print(" F ");
				}
				else {
					if(j == 0) System.out.print(" " + target[i-2] + " ");
					else if(comparisonTable[i-1][j-1]) System.out.print(" T ");
					else System.out.print(" F ");
				}
			}
		}
		
	}
	
	
}
