import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		for (int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(sc.nextLine());
		}
		int avg = Arrays.stream(arr).sum() / 5;
		Arrays.sort(arr);
		System.out.println(avg);
		System.out.println(arr[2]);
	}
}
