package array_1D;

import java.util.Scanner;

//Sort an array of 0s and 1s.

//Sample Input
//7
//1 0 0 1 1 0 1

//Sample Output
//0 0 0 1 1 1 1

public class P5_SortAnArrayOf0sAnd1s {

public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0; i<n; i++)
			a[i] = sc.nextInt();
		
		sortArray(a);
		
		for(int ele : a)
			System.out.print(ele + " ");
		sc.close();
	}
	
	public static void sortArray(int a[])
	{
		//We need 2 pointers here.
		int left = 0, right = a.length - 1;
		while(left < right)
		{
			if(a[left] == 1)
			{
				int temp = a[right];
				a[right] = a[left];
				a[left] = temp;
				right--;
			}
			else 
				left++;
		}
	}
}
