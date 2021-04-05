package array_1D;

import java.util.Scanner;

//Given an array, Treat each element of the array as the digit and whole array as the number. 
//Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers.
//If such arrangement is not possible, it must be rearranged as the lowest possible order ie, sorted in an ascending order.
//Note: The replacement must be in-place, do not allocate extra memory.

//Sample Input
//2
//3
//1 2 3 
//3
//3 2 1

//Sample Output
//1 3 2
//1 2 3

//Explanation
//Possible permutations for {1,2,3} are {1,2,3} , {1,3,2} , {2,1,3} , {2,3,1}, {3,1,2} and {3,2,1}. {1,3,2} is the immediate next permutation after {1,2,3}.
//For the second test case, {3,2,1} is the last configuration so we print the first permutation as its next permutation.

//Must read this article, amazing for understand this concept
//Medium article link : https://medium.com/trick-the-interviwer/next-greater-permutation-bb12e014e797 

public class P8_NextPermutation {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- > 0)
		{
			int n = sc.nextInt();
			int nums[] = new int[n];
			for(int i=0; i<n; i++)
				nums[i] = sc.nextInt();
			
			nextPermutation(nums);
			
			for(int ele : nums)
				System.out.print(ele + " ");
		}
		
		sc.close();
	}
	
//Before moving onto this algorithm, first read the medium's article.
//Observe the test cases(case 1, case 2) explained in that and then move to this algorithm
	
//	Algorithm The steps to solve this problem:
//
//	1)Scan from right to left, find the first element that is less than its previous one.
//
//		4 5 6 3 2 1 
//		  |
//		  p
//		
//	2)Scan from right to left, find the first element that is greater than p.
//
//		4 5 6 3 2 1 
//		    |
//		    q
//	
//	3)Swap p and q
//
//		4 5 6 3 2 1 
//		swap
//		4 6 5 3 2 1 
//
//	4)Reverse elements [p+1, nums.length]
//
//		4 6 1 2 3 5

	public static void nextPermutation(int nums[])
	{
		if(nums.length < 2)
			return;
		
		int n = nums.length;
		
		//step 1
		int p = -1;
		for(int i=n-2; i>=0; i--)
		{
			if(nums[i] < nums[i+1])
			{
				p = i;
				break;
			}
		}
		
		//step 2
		if(p != -1)
		{
			//To find next greater element on right side
			//nums[] = {6, 7, 4, 8, 6, 5, 3, 2};
			//p = 2 (nums[p] = 4)
			//Here, we want to find next greater element of 4 in right side array(8, 6, 5, 3, 2)
			//We know that all elements on right side are already sorted in decreasing order.
			//so, we start traversing from the end of the array, and when we find the element which is greater than nums[p] (4) we break the loop.
			
			int q = n-1;
			while(q > p)
			{
				if(nums[q] >= nums[p])
					break;
				else
					q--;
			}
			
			//step 3
			int temp = nums[p];
			nums[p] = nums[q];
			nums[q] = temp;
		}
	
		//step 4
		
		//nums[] = {3, 2, 1}
		//p = -1
		//Next Permutation of this : {1, 2, 3}
		
		//index       0  1  2  3  4  5  6  7 
		//nums[] = {6, 7, 4, 8, 6, 5, 3, 2}
		//p = 2(index), q = 5
		//After following step 1,2 and 3
		//nums[] = {6, 7, 5, 8, 6, 4, 3, 2}
		//It's obvious that after 5, remaining elements should be in increasing order because we are finding next permutation. 
 		//Thats why we reverse elements Of after p.
		
		reverse(nums, p+1);
	}

	public static void reverse(int nums[], int si)
	{
		int i=si, j=nums.length-1;
		while(i < j)
		{
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
	}
}

//Time Complexity = O(n){to find first decreasing element in the worst case, e.g. [1,5,4,3,2]} 
//                + O(n) {to find the next greater number in the remaining sub array on the right}
//                + O(1) {to swap the first decreasing element with next larger element}
//                + O(n/2) {to reverse the sub array from i+1 to len to sort into ascending order}
//                
//                = O(n)