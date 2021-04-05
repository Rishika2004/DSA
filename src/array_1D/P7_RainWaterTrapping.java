package array_1D;

import java.util.Scanner;

//You are given an input array whose each element represents the height of a line towers.
//The width of every tower is 1.
//It starts raining. Water is filled between the gap of towers if possible. 
//You need to find how much water filled between these given towers.

//Sample Input
//2
//6
//3  0  0  2  0  4
//12
//0  1  0  2  1  0  1  3  2  1  2  1

//Sample Output
//10
//6

//An element of an array can store water if there are higher bars on left and right.
//We can find the amount of water to be stored in every element by finding the heights of bars on the left and right sides.
//The idea is to compute the amount of water that can be stored in every element of the array. 
//For example, consider the array {3, 0, 0, 2, 0, 4}, we can store two units of water at indexes 1 and 2, and one unit of water at index 2.

//A Simple Solution is to traverse every array element and find the highest bars on left and right sides.
//Take the smaller of two heights.
//The difference between smaller height and height of the current element is the amount of water that can be stored in this array element. 
//The time complexity of this solution is O(n2).

//An Efficient Solution is to the pre-compute highest bar on left and right of every bar in O(n) time.
//Then use these pre-computed values to find the amount of water in every array element.


public class P7_RainWaterTrapping {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- > 0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i=0; i<n; i++)
				a[i] = sc.nextInt();

			//System.out.println(maxWater(a));
			System.out.println(maxWater_Optimized(a));
		}
		
		sc.close();
	}
	
	//Time Complexity : O(n)
	//Space Complexity : O(n)
	public static int maxWater(int a[])
	{
		int n = a.length;
		int left[] = new int[n];
		int right[] = new int[n];
	
		int leftMax = a[0];
		left[0] = a[0];
		for(int i=1; i<n; i++)
		{
			if(a[i] > leftMax)
				leftMax = a[i];
			left[i] = leftMax;
		}
		
		int rightMax = a[n-1];
		right[n-1] = a[n-1];
		for(int i=n-2; i>=0; i--)
		{
			if(a[i] > rightMax)
				rightMax = a[i];
			right[i] = rightMax;
		}
		
		int total = 0;
		for(int i=0; i<n; i++)
		{
			total += (Math.min(left[i], right[i]) - a[i]);
		}
		
		return total;
	}
	
	//Time Complexity : O(n)
	//Space Complexity : O(1)
	public static int maxWater_Optimized(int a[])
	{
		int l = 0, r = a.length-1;
        int lMax = 0, rMax = 0;
        
        int total = 0;
        while(l < r)
        {
            if(a[l] < a[r])
            {
                if(a[l] > lMax)
                    lMax = a[l];
                else
                    total += (lMax - a[l]);
                l++;
            }
            else
            {
                if(a[r] > rMax)
                    rMax = a[r];
                else
                    total += (rMax - a[r]);
                r--;
            }
        }
        
        return total;
	}
}