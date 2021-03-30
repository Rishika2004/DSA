package recursion;

import java.util.Scanner;

//You are given n numbers, where ith element's value represents - till how far from the step you 
//could jump to in a single move.  You can of-course fewer number of steps in the move.
//You are required to print the number of minimum moves in which you can reach the top of 
//staircase.

//Sample Input
//10
//3 3 0 2 1 2 4 2 0 0

//Sample Output
//4
public class ClimbStairsWithMinimumMoves {

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
	
	public static Integer climbingStairs(int n, int arr[])
	{
		return climbingStairs(0, arr, n);
	}

	private static Integer climbingStairs(int current, int[] arr, int n) {
	
		//If it's possible to reach at nth stair, then we return 0.
		if(current == n)
			return 0;
		
		//If it's impossible to reach at nth stair, then we return null.
		if(current > n)
			return null;
		
		int min = Integer.MAX_VALUE;
		
		for(int i=1; i<=arr[current]; i++)
		{
			Integer moves = climbingStairs(current + i, arr, n);
			min = Math.min(min, moves);	
			//Math.Min(Integer.MAX_VALUE, null) -> Integer.MAX_VALUE
			//Math.min(10, null) -> 10
			
		}
		
		//if min is still Integer.MAX_VALUE, that means there is no ways to reach at nth stair.so, we return null if there's no way.
		if(min != Integer.MAX_VALUE)
			return 1 + min;
		else
			return null;
	}
}
