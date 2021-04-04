package array_1D;
//You are provided two sorted arrays. 
//You need to find the maximum length of bitonic subsequence. 
//You need to find the sum of the maximum sum path to reach from beginning of any array to end of any of the two arrays. 
//You can switch from one array to another array only at common elements.

import java.util.Scanner;

//Sample Input
//1
//8 8
//2 3 7 10 12 15 30 34
//1 5 7 8 10 15 16 19

//Sample Output
//122

//Explanation
//122 is sum of 1, 5, 7, 8, 10, 12, 15, 30, 34



public class P1_MaximumSumPathInTwoArrays {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int a1[] = new int[n1];
		for(int i=0; i<n1; i++)
			a1[i] = sc.nextInt();
		
		int a2[] = new int[n2];
		for(int i=0; i<n2; i++)
			a2[i] = sc.nextInt();
		
		//Here, we first take sum1 and sum2 for array1 and array2 respectively.
		//which will store the sum separately before the common element.
		//So that, we can judge the maximum sum between the two and can add the max one into our ans.
		int sum1 = 0, sum2 = 0, ans = 0;
		int i=0, j=0;
		while(i < n1 && j < n2)
		{
			if(a1[i] < a2[j])
				sum1 += a1[i++];
			else if(a2[j] < a1[i])
				sum2 += a2[j++];
			else
			{
				ans += Math.max(sum1, sum2);
				
				sum1 = 0;
				sum2 = 0;
				
				int temp = a1[i];
				while(i<n1 && a1[i] == temp)
					sum1 += a1[i++];
				while(j<n2 && a2[j] == temp)
					sum2 += a2[j++];
				
				ans += Math.max(sum1, sum2);
				sum1 = 0;
				sum2 = 0;
			}
		}
		
		while(i < n1)
			sum1 += a1[i++];
		
		while(j < n2)
			sum2 += a2[j++];
		
		ans += Math.max(sum1, sum2);
		
		System.out.println(ans);
	}
}