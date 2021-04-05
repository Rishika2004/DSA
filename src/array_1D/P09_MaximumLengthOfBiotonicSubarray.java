package array_1D;

import java.util.Scanner;

//You are provided n numbers of array. 
//You need to find the maximum length of bitonic subarray. 
//A subarray A[i … j] is biotonic if there is a k with i <= k <= j such that A[i] <= A[i + 1] … <= A[k] >= A[k + 1] >= .. A[j – 1] > = A[j] 
//i.e subarray is first increasing and then decreasing or entirely increasing or decreasing.

//Sample Input
//2
//6
//12 4 78 90 45 23
//4
//40 30 20 10

//Sample Output
//5
//4

//Explanation
//ForMaximum length = 4, 78, 90, 45, 23

public class P09_MaximumLengthOfBiotonicSubarray {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- > 0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i=0; i<n; i++)
				a[i] = sc.nextInt();
			
			int max = bitonic(a);
			System.out.println(max);

//			int max2 = bitonic2(a);
//			System.out.println(max2);
		}
		
		sc.close();
	}
	
//	Approach
//	We create two arrays - 'inc' and 'dec'
//	1) inc[i] stores the length of increasing subarray till i.
//	2) dec[i] stores the length of decreasing subarray starting from index i.
//	3) Doing so gives us the length of increasing and decreasing subarray at each index in O(n) time.
//	4) We calculate the length of the longest bitonic subarray by finding the maximum inc[i] + dec[i] - 1
//	5) We subtract one since the current element at ith index is included in both the increasing and decreasing subarray lengths.
	
//	Algorithm	
//	1) Initialize inc[0] to 1 and dec[n-1] to 1
//	2) Creating inc[] array
//	   Till end of the array ie, i=1 to n, if arr[i] > arr[i-1] then inc[i] = inc[i-1] + 1. else, inc[i] = 1
//	3) Creating dec[] array
//	   From the end of the array ie, i = n-2 till i =0, if arr[i] > arr[i+1] then dec[i] = dec[i+1] +1 else, dec[i] = 1
//	4) Calculate the length of the longest bitonic subarray by finding the maximum inc[i] + dec[i] - 1

	//Time Complexity : O(n + n + n)
	//space Complexity : O(n + n)
	public static int bitonic(int a[]) 
    {
		int n = a.length;
		
		int in[] = new int[n];
		int de[] = new int[n];
		
		in[0] = 1;
		for(int i=1; i<n; i++)
		{
			if(a[i] >= a[i-1])
				in[i] = in[i-1] + 1;
			else
				in[i] = 1;
		}
		
		de[n-1] = 1;
		for(int i=n-2; i>=0; i--)
		{
			if(a[i] >= a[i+1])
				de[i] = de[i+1] + 1;
			else
				de[i] = 1;
		}
		
		int max = 1;
		for(int i=0; i<n; i++)
		{
			int val = de[i] + in[i] - 1;
			if(val > max)
				max = val;
		}
		
		return max;
			
    }
	
	//optimized
	//Time Complexity : O(n + n)
	//Space Complexity : O(n)
	public static int bitonic2(int a[]) 
    {
		int n = a.length;
		
		int in[] = new int[n];
		
		in[0] = 1;
		for(int i=1; i<n; i++)
		{
			if(a[i] >= a[i-1])
				in[i] = in[i-1] + 1;
			else
				in[i] = 1;
		}
		
		int deCount = 1; //de[n-1] = 1
		int max = in[n-1] + deCount - 1; //answer
		
		for(int i=n-2; i>=0; i--)
		{
			if(a[i] >= a[i+1])
			{
				deCount++;
			}
			else
			{
				deCount = 1;
			}
			
			if(in[i] + deCount - 1 > max)
				max = in[i] + deCount - 1;
		}
		
		return max;
    }  
}