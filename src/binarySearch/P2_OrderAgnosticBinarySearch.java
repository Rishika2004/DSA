package binarySearch;

import java.util.Scanner;

//Array is sorted in descending order

//Input
//7
//56 52 45 31 28 22 14
//22

//Output
//5

public class P2_OrderAgnosticBinarySearch {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		int target = sc.nextInt();
		int idx = binarySearchD(arr, target);
		System.out.println(idx);
		sc.close();
	}
	
	public static int binarySearchD(int arr[], int target)
	{
		int start = 0;
		int end = arr.length-1;
		
		while(start <= end)
		{
			int mid = start + (end-start) / 2;
			
			if(target == arr[mid])
				return mid;
			else if(target > arr[mid])
				end = mid - 1;
			else
				start = mid + 1;
		}
		
		return -1;
	}
}