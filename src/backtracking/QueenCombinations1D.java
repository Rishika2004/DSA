package backtracking;

import java.util.Scanner;

//You are given n queens and m boxes. you need to print all possible combinations of arrangement of these n queens into m boxes.
//In short, Here we need to find nCr.
public class QueenCombinations1D {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		queenCombinations(n, m);
		sc.close();
	}
	
	public static void queenCombinations(int n, int m)
	{
		queenCombinations(0, n, m, "", -1);
	}

	private static void queenCombinations(int cur, int n, int m, String osf, int lastBoxUsed) {
	
		if(cur == n)
		{
			System.out.println(osf);
			return;
		}
		
		for(int i=lastBoxUsed+1; i<m; i++)
		{
			queenCombinations(cur+1, n, m, osf + "q" + cur + "b" + i + " ", i);
		}
	}		
}