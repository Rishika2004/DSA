package array_1D;

import java.util.Scanner;

//Take as input N, a number.
//Take N more inputs to form an array.
//Reorder items of array in such a manner that all 0’s are moved to end.
//Target complexity is O(n)

//Sample Input
//5
//0 0 0 0 1

//Sample Output
//1 0 0 0 0
public class P6_0sAtEnd {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0; i<n; i++)
			a[i] = sc.nextInt();
		
		move0sAtEnd(a);
		for(int ele : a)
			System.out.print(ele + " ");
		
		sc.close();
	}
	
	public static void move0sAtEnd(int a[])
	{
		//We need 2 pointers here.
		int left = 0, right = a.length - 1;
		while(left < right)
		{
			if(a[left] == 0)
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
