package backtracking;

//Sample Input
//4
//2 3 5 6
//10

//Sample Output
//22222
//2233
//226
//235
//55

import java.util.Scanner;

public class CoinChangeCombinations {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int denom[] = new int[n];
		for(int i=0; i<n; i++)
			denom[i] = sc.nextInt();
		int amount = sc.nextInt();
		coinChange(denom, amount, "", 0);
		sc.close();
	}
	
	public static void coinChange(int denom[], int amount, String osf, int lastDenomIndex)
	{
		if(amount == 0)
		{
			System.out.println(osf);
			return;
		}
	
		if(amount < 0)
			return;
		
		for(int i=lastDenomIndex; i<denom.length; i++)
			coinChange(denom, amount - denom[i], osf + denom[i], i);
	}
}
