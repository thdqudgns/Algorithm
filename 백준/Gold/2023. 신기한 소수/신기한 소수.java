import java.util.Scanner;

public class Main {
	static int N;
	// N이 들어오면, range[N] ~ range[N+1] 만 탐색한다.
	static int[] range = {0, 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// 첫번째 자리수가 소수가 아니면 pass
		int[] one = {0, 0, 1, 1, 0, 1, 0, 1, 0, 0};
		
		if (N == 1) {
			System.out.println(2);
			System.out.println(3);
			System.out.println(5);
			System.out.println(7);
			return;
		}
		
		// N이 2 이상일 때 자리수를 찾아보자, 홀수만 보자 -> 마지막 자리수 안 봐도 됨
		for (int num = range[N]+1; num < range[N+1]; num += 2) {
			// 마지막 자리수가 5라면 continue;
			if (num % 5 == 0) continue;
			// 앞에서 첫번째 자리수가 소수가 아니면 continue;
			if (one[ num / range[N] ] != 1) continue;
			// 둘째자리도 보자
			int two = num / range[N-1] % 10;
			if (two != 1 && two != 3 && two != 7 && two != 9) continue;
			findSpecial(num);
		}
		System.out.println(sb);
	}
	private static void findSpecial(int num) {
		boolean flag = true;

		for (int i = N-1; i > 0; i--) {	// i = ... 1000, 100, 10, 1
			int tmp = num / range[i];
			flag = isPrime(tmp);
			if (!flag) return;
		}
		//신기한 수이면
		if (flag) sb.append(num).append('\n');
	}
	private static boolean isPrime(int num) {
		for (int j = 2; j*j < num; j++) {
			if (num % j == 0) return false;
		}
		return true;
	}
}
