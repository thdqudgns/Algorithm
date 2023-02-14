import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] arr, numbers, result;
	static int N = 9;
	static int R = 2;
	static int aim;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[N];
		numbers = new int[R];
		result = new int[7];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(sc.nextLine());
		}
		int sum = Arrays.stream(arr).sum();
		aim = sum - 100;
		solve(0, 0);
		for (int i = 0; i < 7; i++) {
			System.out.println(result[i]);
		}
	}
	private static void solve(int cnt, int start) {
		if(cnt == R) {
			int sum = Arrays.stream(numbers).sum();
			if (sum == aim) {
				Arrays.sort(arr);
				int idx = 0;
				//System.out.println(sum);
				for (int i = 0; i < N; i++) {
					if (arr[i] == numbers[0] || arr[i] == numbers[1]) continue;
					result[idx++] = arr[i];
				}
			}
			return;
		}
		for (int i = start; i < N; i++) {
			numbers[cnt] = arr[i];
			solve(cnt + 1, i + 1);
		}
	}
}
