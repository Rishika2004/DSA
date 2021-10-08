package binarySearch;

import java.util.Scanner;

//Floor -> Find the largest element in array which is smaller than or equal to target

public class P4_FloorOfNumber {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		int target = sc.nextInt();
		int num = findFloorNum(arr, target);
		System.out.println(num);
		sc.close();
	}
	
	public static int findFloorNum(int arr[], int target)
	{
		int start = 0;
		int end = arr.length-1;
		
		while(start <= end)
		{
			int mid = start + (end - start) / 2;
			
			if(target == arr[mid])
				return arr[mid];
			else if(target < arr[mid])
				end = mid - 1;
			else
				start = mid + 1;
		}
		
		return arr[end];
	}

}
