package string;

import java.util.Arrays;
import java.util.Scanner;

public class P6_SortStringsInLexicographicalOrder {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		
		String[] arr = new String[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.next();
		
		sort(arr);
		for(String s : arr)
			System.out.print(s + " ");
		
		sc.close();
	}
	
	//s1.compareToIgnoreCase(s2)
	//returns
	//0 -> if both strings are equal
	//<0 -> if s1 is less than s2
	//>0 -> if s1 is greater than s2
	
	public static void sort(String arr[])
	{
		int n = arr.length;
		for(int i=0; i<n; i++)
		{
			for(int j=i+1; j<n; j++)
			{
				if(arr[i].compareToIgnoreCase(arr[j]) > 0)
				{
					String temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	public static void sortOpt(String arr[])
	{
		Arrays.sort(arr, String.CASE_INSENSITIVE_ORDER);
	}
}