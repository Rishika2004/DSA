package array_1D;

import java.util.Arrays;
import java.util.Scanner;

//Three arrays of same size are given. 
//Find a triplet such that (maximum – minimum) in that triplet is minimum of all the triplets. 
//A triplet should be selected in a way such that it should have one number from each of the three given arrays.

//If there are 2 or more smallest difference triplets, then the one with the smallest sum of its elements should be displayed.

//Input Format
//First line contains size of the arrays.
//Second line contains the elements of the first array.
//Third line contains the elements of the second array.
//Fourth line contains the elements of the third array.

//Output Format
//Print the triplet in non-increasing order.

//Sample Input
//7
//7 5 4 3 4 3 3 
//3 5 5 3 6 7 6 
//5 7 8 8 5 10 2 

//Sample Output
//5 5 5

public class P10_SmallestDifferenceTriplet {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int arr1[] = new int[n];
		for(int i=0; i<n; i++)
			arr1[i] = sc.nextInt();
		
		int arr2[] = new int[n];
		for(int i=0; i<n; i++)
			arr2[i] = sc.nextInt();
		
		int arr3[] = new int[n];
		for(int i=0; i<n; i++)
			arr3[i] = sc.nextInt();
		
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		Arrays.sort(arr3);
	
		int res_min = 0, res_mid = 0, res_max = 0;
		
		int i = 0, j = 0, k = 0;
		int min_dif = Integer.MAX_VALUE;
		
		while(i < n && j < n && k < n)
		{
			int sum = arr1[i] + arr2[j] + arr3[k];
			
			int min = Math.min(Math.min(arr1[i], arr2[j]), arr3[k]);
			int max = Math.max(Math.max(arr1[i], arr2[j]), arr3[k]);
		
			if(min == arr1[i])
				i++;
			else if(min == arr2[j])
				j++;
			else
				k++;
			
			if((max - min) < min_dif)
			{
				min_dif = max - min;
				res_max = max; 
                res_mid = sum - (max + min); 
                res_min = min;
			}
		}
			
		System.out.print(res_max + " " + res_mid + " " + res_min);
		
		sc.close();
	}
}
