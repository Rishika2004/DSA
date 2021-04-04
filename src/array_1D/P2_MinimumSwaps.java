package array_1D;

import java.util.Scanner;

//You are given an unordered array consisting of consecutive integers [1, 2, 3, …, n] without any duplicates.
//You are allowed to swap any two elements. 
//You need to find the minimum number of swaps required to sort the array in ascending order.

//Sample Input
//4
//4 3 1 2

//Sample Output
//3
public class P2_MinimumSwaps {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0; i<n; i++)
			a[i] = sc.nextInt();
		int minSwaps = minimumSwaps(a);
		System.out.println(minSwaps);
		sc.close();
	}
	
	public static int minimumSwaps(int a[])
	{
		int count = 0;
		int i=0;
		while(i < a.length)
		{
			//The possibility to execute this if condition is O(n)
			//Maximum n-1 swaps possible
			//Sample Input
			//10
			//10 1 2 3 4 5 6 7 8 9
			//Sample Output
			//9
			//This test is worst case scenario. Because the maximum n-1 swaps can be possible to sort an array.
			//In this test case, if block will execute n-1 -> O(n) time
			//and else block will execute for remaining n-1 elements, because for all others a[i] = i+1, thst's why it will just increment the value of i. So, else block will execute n-1 -> O(n) time
			//So, the total time complexity : n-1(if block) + n-1(else block) = 2n - 2 = O(n) 
			//Dry run the code, to understand it better.
			if(a[i] != i+1)
			{
				int temp = a[a[i]-1];
				a[a[i]-1] = a[i];
				a[i] = temp;
				count++;
			}
			else i++;
		}
		return count;
	}
}
//100
//8 45 35 84 79 12 74 92 81 82 61 32 36 1 65 44 89 40 28 20 97 90 22 87 48 26 56 18 49 71 23 34 59 54 14 16 19 76 83 95 31 30 69 7 9 60 66 25 52 5 37 27 63 80 24 42 3 50 6 11 64 10 96 47 38 57 2 88 100 4 78 85 21 29 75 94 43 77 33 86 98 68 73 72 13 91 70 41 17 15 67 93 62 39 53 51 55 58 99 46
//91