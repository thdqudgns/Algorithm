import java.util.Scanner;

public class Main {
	static int N, K;
	static long cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		cnt = 0;
		
		comb(0,0);
		System.out.println(cnt%10007);
	}
	private static void comb(int c, int start) {
		if (c == K) {
			cnt++;
			return;
		}
		for (int k = start; k < N; k++) {
			comb(c + 1, k + 1);
		}
	}
}
