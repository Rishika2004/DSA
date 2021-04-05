package array_1D;
import java.util.Scanner;
import java.util.Arrays;

//Take as input N, the size of array. 
//Take N more inputs and store that in an array.
//Take as input “target”, a number.
//Write a function which prints all triplets of numbers which sum to target.

//Sample Input
//9
//5 7 9 1 2 4 6 8 3
//10

//Sample Output
//1, 2 and 7
//1, 3 and 6
//1, 4 and 5
//2, 3 and 5

//Explanation
//Array = {5, 7, 9, 1, 2, 4, 6 ,8 ,3}. Target number = 10. 
//Find any three number in the given array which sum to target number.

public class P03_TargetSumTriplet {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();
        printTriplet(arr, target);
        
        sc.close();
    }
	
	public static void printTriplet(int[] arr, int target) {
    
		//Two pointers algorithm can be applied only on sorted array.
		Arrays.sort(arr);
		
        for (int i = 0; i < arr.length; i++) {
        
        	int left = i + 1;
            int right = arr.length - 1;
            int smallTarget = target - arr[i];
            
            while (left < right) {
            
            	if (arr[left] + arr[right] == smallTarget) {
                    System.out.println(arr[i] + ", " + arr[left] + " and " + arr[right]);
                    left++;
                    right--;
                }
            	else if (arr[left] + arr[right] < smallTarget)
                    left++;
                else
                    right--;
            }
        }
    }
}