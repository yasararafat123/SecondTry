import java.util.ArrayList;

public class SecondTry {

	public static void main(String[] args) {
		int numberOfCriteria = 5;
		int numberOfAlternatives = 5;
		//INPUT
		int[][] table = new int[numberOfCriteria][numberOfAlternatives];
//		table[0] = new int[] {2,3,1,2,3};
//		table[1] = new int[] {2,3,0,1,3};
//		table[2] = new int[] {0,1,0,0,1};
//		table[3] = new int[] {0,2,0,0,1};
//		table[4] = new int[] {0,0,0,0,0};
		table[0] = new int[] {3,2,2,1,1};
		table[1] = new int[] {0,1,2,1,2};
		table[2] = new int[] {0,0,0,0,0};
		table[3] = new int[] {0,0,0,0,0};
		table[4] = new int[] {0,0,0,0,0};
		
		int[] finalRank = new int[numberOfAlternatives];
		for(int i=0;i<numberOfAlternatives;i++) {
			finalRank[i] = 0;
		}
		
		int n = 0;
		for(int c = numberOfCriteria-1;c>=0;c--) {
			int numberOfFilledElements = 0; // number of filled elements from finalRank in this iteration (line)
			for(int a=0;a<numberOfAlternatives;a++) {
				if(finalRank[a] == 0 && table[c][a] != 0) {
					finalRank[a] = n + table[c][a];
					if(finalRank[a] > numberOfAlternatives) {
						finalRank[a] = getLargestNumberFilled(finalRank, a) + 1;
					}
					numberOfFilledElements ++;
				}
			}
			
			ArrayList<Integer> duplicates = getDuplicateElements(finalRank);
			if(duplicates.size() > 0) {
				for (Integer duplicate : duplicates) {
					//System.out.println("duplicate: " + duplicate);
					finalRank[duplicate] = 0;
				}
				numberOfFilledElements -= duplicates.size();
			} else {
				if(isFilled(finalRank)) {
					break;
				}
			}
			n = n + numberOfFilledElements;
		}
		for(int i=0;i<numberOfAlternatives;i++) {
			System.out.println(finalRank[i]);
		}
		
	}
	public static int getLargestNumberFilled(int[] finalRank, int excludeIndex) {
		int largest = 0;
		for(int i=0;i<finalRank.length;i++) {
			if(i != excludeIndex && finalRank[i] > largest) {
				largest = finalRank[i];
			}
		}
		return largest;
	}
	public static boolean isFilled(int[] finalRank) {
		for(int i=0;i<finalRank.length;i++) {
			if(finalRank[i] == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static ArrayList<Integer> getDuplicateElements(int[] finalRank) {
		ArrayList<Integer> duplicates = new ArrayList<>();
		for (int i = 0; i < finalRank.length-1; i++) {
	        for (int j = i+1; j < finalRank.length; j++) {
	             if (finalRank[i] == finalRank[j] && finalRank[i] != 0) {
	            	 duplicates.add(i);
	            	 duplicates.add(j);
	             }
	        }
	    }
		return duplicates;
	}

}
