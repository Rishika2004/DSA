package backtracking;
//You are given n queens and m boxes. 
//you need to print all possible permutations to arrange these n queens into m boxes.
//In short here we need to find nPr.

//Sample Input:
//2 -> total queens : q0, q1
//4 -> total boxes : b0, b1, b2, b3

//Sample Output:
//q0b0 q1b1 
//q0b0 q1b2 
//q0b0 q1b3 
//q0b1 q1b0 
//q0b1 q1b2 
//q0b1 q1b3 
//q0b2 q1b0 
//q0b2 q1b1 
//q0b2 q1b3 
//q0b3 q1b0 
//q0b3 q1b1 
//q0b3 q1b2 

import java.util.Scanner;

public class QueenPermutation1D {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		queenPermutation(n, m);
		sc.close();
	}
	
	//n -> queens
	//m -> boxes
	public static void queenPermutation(int n, int m)
	{
		boolean boxes[] = new boolean[m];
		queenPermutation(n, m, 0, boxes, "");
	}
	
	//qpsf -> queen places so far
	//osf -> output so far
	public static void queenPermutation(int n, int m, int qpsf, boolean boxes[], String osf)
	{
		if(qpsf == n)
		{
			System.out.println(osf);
			return;
		}
		
		for(int i=0; i<m; i++)
		{
			if(!boxes[i])
			{
				boxes[i] = true;
				queenPermutation(n, m, qpsf + 1, boxes, osf + "q" + qpsf + "b" + i + " ");
				boxes[i] = false;
			}
		}
	}
}