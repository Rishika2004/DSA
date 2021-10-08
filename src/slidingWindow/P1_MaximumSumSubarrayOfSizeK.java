package slidingWindow;

import java.util.Scanner;

//7 <- n
//2 5 1 8 2 9 1
//3 <- window size k

//answer :  19

public class P1_MaximumSumSubarrayOfSizeK {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0; i<n; i++)
			a[i] = sc.nextInt();
		
		int k = sc.nextInt();
		
		int max = Integer.MIN_VALUE;
		int sum = 0;
		
		int i=-1, j=-1;
		while(i < k-2)
		{
			i++;
			sum += a[i];
		}
		
		while(i < n-1)
		{
			i++;
			sum += a[i];
			if(sum > max)
				max = sum;
			
			j++;
			sum = sum - a[j];
		}
		
		System.out.println(max);
		sc.close();
	}
}