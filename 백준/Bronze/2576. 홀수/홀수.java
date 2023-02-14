import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[7];
		int min = 100;
		int sum = 0;
		boolean flag = false;
		for (int i = 0; i < 7; i++) {
			arr[i] = Integer.parseInt(sc.nextLine());
			if (arr[i] % 2 == 1) {
				flag = true;
				min = Math.min(min, arr[i]);
				sum += arr[i];
			}
		}
		if (flag) {
			System.out.println(sum);
			System.out.print(min);
		} else {
			System.out.print(-1);
		}
	}
}
