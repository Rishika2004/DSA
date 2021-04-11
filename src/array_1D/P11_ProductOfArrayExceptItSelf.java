package array_1D;

import java.util.Scanner;

//Given an integer array a, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

//Sample Input 1
//4
//1 2 3 4

//Sample Output 1
//24 12 8 6
		
//Sample Input 2
//5
//-1 1 0 -3 3

//Sample Output 2
//0 0 9 0 0

public class P11_ProductOfArrayExceptItSelf {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int a[] = new int[n];
		for(int i=0; i<n; i++)
			a[i] = sc.nextInt();
		
		int[] ans = productExceptSelf_Optimized(a);
		for(int ele : ans)
			System.out.print(ele + " ");
		
		sc.close();
	}
	
	//Time Complexity : O(n)
	//Space Complexity : O(n)
	public static int[] productExceptSelf(int a[])
	{
		int n = a.length;
		int left[] = new int[n];
		int right[] = new int[n];
		
		//at each index, we store the product of all elements from left side except that element.
		left[0] = 1;
		for(int i=1; i<n; i++)
		{
			left[i] = a[i-1] * left[i-1];
		}
		
		right[n-1] = 1;
		for(int i=n-2; i>=0; i--)
		{
			right[i] = a[i+1] * right[i+1];
		}
	
		//Make any one of this as our answer 
		//Here, we are considering left as our answer
		
		for(int i=0; i<n; i++)
		{
			left[i] = left[i] * right[i];
		}
		
		return left;
	}
	
	//Time Complexity : O(n)
	//Space Complexity : O(1)
	public static int[] productExceptSelf_Optimized(int a[])
	{
		int n = a.length;
        int[] ans = new int[n];
        
        ans[0] = 1;
        for(int i=1; i<n; i++)
        {
            ans[i] = ans[i-1] * a[i-1]; 
        }
        
        int right = 1;
        for(int i=n-1; i>=0; i--)
        {
            ans[i] = ans[i] * right;
            right = right * a[i];
        }
        
        return ans;
	}
}
