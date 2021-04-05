package array_1D;

import java.util.Scanner;

//You will be given an array containing only 0s, 1s and 2s. 
//you have sort the array in linear time that is O(N) where N is the size of the array.

//Sample Input
//5
//0 1 2 1 2

//Sample Output
//0 1 1 2 2

public class P04_SortAnArrayOf0s1sAnd2s {

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
		//Here, we need to take 3 pointers.
		int left = 0, mid = 0, right = a.length - 1; 
		
		//Here, we have to put mid <= right
		//Because mid < right will not work for the following type of cases.
		//Input
		//8
		//2 0 1 1 2 0 0 0
		//Output
		//0 0 0 1 1 0 2 2 (mid < right) (at 5th index, mid = 4, right = 5 and when mid becomes 5 then this condition(5(mid) < 5(right)) becomes false. This will not check for i=5, if at 5th index,there will be 1 or 2, then it will work completely fine, but if it's 0, then it gives wrong answer.)
		//Expected Output
		//0 0 0 0 1 1 2 2
		
		while(mid <= right)
		{
			if(a[mid] == 2)
            {
                int temp = a[right];
                a[right] = a[mid];
                a[mid] = temp;
                right--;
                //Values come from right side can be 0 or 1.
                //If, it's 1 then we can increase mid.
                //But, it can be 0 also, in that case, a[mid] == 0 should be executed.
                //That's why we are not increasing mid here directly.
            }
            else if(a[mid] == 0)
            {
                int temp = a[left];
                a[left] = a[mid];
                a[mid] = temp;
                left++;
                //Values come from left side will be definitely 1.
                //That's why we increase mid here.
                mid++;
            }
            else
                mid++;
		}
	}
}
