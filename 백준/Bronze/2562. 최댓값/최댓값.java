import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[9];
		int max = Integer.MIN_VALUE;
		int index = -1;
		for (int i = 0; i < nums.length; i++) {
			nums[i] = sc.nextInt();
			if (nums[i] > max) {
				max = nums[i];
				index = i+1;
			}
		}
		System.out.println(max);
		System.out.println(index);
	}
}
