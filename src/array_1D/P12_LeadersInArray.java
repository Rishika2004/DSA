package array_1D;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//Write a program to print all the LEADERS in the array. 
//An element is leader if it is greater than all the elements to its right side. 
//And the rightmost element is always a leader. 
//For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.

//Sample Input
//4
//5 7 10 6 

//Sample Output
//6 10 


public class P12_LeadersInArray {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int a[] = new int[n];
		for(int i=0; i<n; i++)
			a[i] = sc.nextInt();
		
		ArrayList<Integer> list = findLeaders(a);
		
		for(int ele : list)
			System.out.print(ele + " ");
		
		sc.close();
	}
	
	public static ArrayList<Integer> findLeaders(int a[])
	{
		int n = a.length;
		ArrayList<Integer> list = new ArrayList<>();
	
		int rightMax = Integer.MIN_VALUE;
		
		for(int i=n-1; i>=0; i--)
		{
			if(a[i] > rightMax)
			{
				list.add(a[i]);
				rightMax = a[i];
			}
		}
		
		Collections.sort(list);
		
		return list;
	}
}
