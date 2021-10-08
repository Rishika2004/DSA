package slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//1. You are given an array(arr) of integers and a number K.
//2. You have to find the count of distinct numbers in all windows of size k.

//Sample Input
//7
//1 2 1 3 4 2 3        
//4

//Sample Output
//3 4 4 3 
public class P2_DistinctElementsInWindowOfSizeK {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0; i<n; i++)
			a[i] = sc.nextInt();
		int k = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int i=-1, j=-1;
		while(i < k-2)
		{
			i++;
			map.put(a[i], map.getOrDefault(a[i], 0) + 1);
		}
		
		while(i < n-1)
		{
			//acquire
			i++;
			map.put(a[i], map.getOrDefault(a[i], 0) + 1);
			
			//work
			list.add(map.size());
			
			//release
			j++;
			int freq = map.get(a[j]);
			if(freq == 1)
				map.remove(a[j]);
			else
				map.put(a[j], freq - 1);
			
		}
		
		System.out.println(list);
	
		sc.close();
	}
}