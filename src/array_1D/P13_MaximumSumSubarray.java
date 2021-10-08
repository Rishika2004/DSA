package array_1D;

public class P13_MaximumSumSubarray {

	public static void main(String[] args) {

		int arr[] = {-2,1,-3,4,-1,2,1,-5,4}; 
		int ans = kadane(arr); // ans = 6
		System.out.println(ans);
	}
	
	public static int kadane(int[] arr) {

		int sum = arr[0];
		int max = arr[0];

		for (int i = 1; i < arr.length; i++) {

			sum = Math.max(sum + arr[i], arr[i]);

			if (sum > max)
				max = sum;
		}

		return max;

	}

}
