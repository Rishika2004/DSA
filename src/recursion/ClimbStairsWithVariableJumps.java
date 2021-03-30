package recursion;

import java.util.Scanner;

//You are given n numbers, where ith element's value represents - till how far from the step you 
//could jump to in a single move.  
//You can of course jump fewer number of steps in the move.
//You are required to print the number of different paths via which you can climb to the top.

//Sample Input
//10
//3 3 0 2 1 2 4 2 0 0

//Sample Output
//5

public class ClimbStairsWithVariableJumps {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		int totalWays = climbingStairs(n, arr);
		System.out.println(totalWays);
		sc.close();
	}
	
	private static int climbingStairs(int n, int[] arr) {
		
		return climbingStairs(0, arr, n);
	}


	public static int climbingStairs(int current, int arr[], int n)
	{
		//Positive base case
		if(current == n)
			return 1;
		
		//Negative base case
		if(current > n)
			return 0;
		
		int count = 0;
		for(int i=1; i<=arr[current]; i++)
		{
			count += climbingStairs(current + i, arr, n);
		}
		
		return count;
	}
}
