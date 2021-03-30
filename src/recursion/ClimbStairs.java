package recursion;

import java.util.Scanner;

//You are on the 0th step and are required to climb to the top.
//In one move, you are allowed to climb 1, 2 or 3 stairs.

public class ClimbStairs {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int totalWays = climbingStairs(n);
		System.out.println("Total Ways : " + totalWays);
		sc.close();
	}
	
	public static int climbingStairs(int n)
	{
		return climbingStairs(0, "", n);
	}

	private static int climbingStairs(int current, String osf, int n) {
		
		//positive base case
		if(current == n)
		{
			System.out.println(osf);
			return 1;
		}
		
		//negative base case
		if(current > n)
			return 0;
		
		int count = 0;
		count += climbingStairs(current + 1, osf + "1", n);
		count += climbingStairs(current + 2, osf + "2", n);
		count += climbingStairs(current + 3, osf + "3", n);
		
		return count;
	}

}
