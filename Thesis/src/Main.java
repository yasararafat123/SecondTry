import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numberOfCriteria = 5;
		int numberOfAlternatives = 5;
		int[][] table = new int[numberOfCriteria][numberOfAlternatives];
		table[0] = new int[] {1,2,2,1,3};
		table[1] = new int[] {2,1,2,1,3};
		table[2] = new int[] {1,3,2,1,4};
		table[3] = new int[] {5,3,4,2,1};
		table[4] = new int[] {1,2,3,4,5};
		
		
		
		
		for(int i=0;i<numberOfCriteria;i++) {
			ArrayList<Integer> ones = new ArrayList<>();
			ArrayList<Integer> twos = new ArrayList<>();
			ArrayList<Integer> threes = new ArrayList<>();
			ArrayList<Integer> forths = new ArrayList<>();
			ArrayList<Integer> fives = new ArrayList<>();
			
			for(int j=0;j<numberOfAlternatives;j++) {
				switch (table[i][j]) {
					case 1: {
						ones.add(j);
						break;
					}
					case 2: {
						twos.add(j);
						break;
					}
					case 3: {
						threes.add(j);
						break;
					}
					case 4: {
						forths.add(j);
						break;
					}
					case 5: {
						fives.add(j);
						break;
					}
				}
				int numberOfCellsLeft = 5;
				for(int k=1;k<=numberOfAlternatives;k++) {
					
					
					
					if(numberOfCellsLeft == 0) {
						break;
					}
				}
			}
		}
		
		

	}

}
