package backtracking;

import java.util.Scanner;

public class NQueenPermutation {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int totalQueens = sc.nextInt();
		int totalBoxes = sc.nextInt();
		queenPermutation(totalQueens, totalBoxes);
		sc.close();
	}
	
	public static void queenPermutation(int tq, int tb)
	{
		boolean boxes[] = new boolean[tb];
		queenPermutation(boxes, 0, tq, "");
	}
	
	public static void queenPermutation(boolean[] boxes, int i, int tq, String osf)
	{
		if(i == tq)
		{
			System.out.println(osf);
			return;
		}
		
		for(int k=0; k<boxes.length; k++)
		{
			if(!boxes[k])
			{
				boxes[k] = true;
				queenPermutation(boxes, i+1, tq, osf + "q" + i + "b" + k + " ");
				boxes[k] = false;
			}
		}
	}
}