package backtracking;

import java.util.Scanner;

//You are given n queens and m boxes. you need to print all possible combinations of arrangement of these n queens into m boxes.
//In short, Here we need to find nCr.

//Sample Input 
//2 4
//(2 -> total queens -> q0, q1)
//(4 -> total boxes -> b0, b1, b2, b3)

//Sample Output
//q0b0 q1b1 
//q0b0 q1b2 
//q0b0 q1b3 
//q0b1 q1b2 
//q0b1 q1b3 
//q0b2 q1b3 


public class QueenCombinations1D {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		queenCombinations(n, m);
		sc.close();
	}
	
	//n -> queens
	//m -> boxes
	public static void queenCombinations(int n, int m)
	{
		queenCombinations(n, m, 0, -1, "");
	}
	
	public static void queenCombinations(int n, int m, int qpsf, int lastBoxUsed, String osf)
	{
		if(qpsf == n)
		{
			System.out.println(osf);
			return;
		}
		
		for(int i=lastBoxUsed+1; i<m; i++)
		{
			queenCombinations(n, m, qpsf+1, i, osf + "q" + qpsf + "b" + i + " ");
		}
	}
}