import java.util.Scanner;

public class Main {
	static boolean[] used1, used2, used3;
	static int N, cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.nextLine());
		used1 = new boolean[N];
		used2 = new boolean[2*N];
		used3 = new boolean[2*N];
		solve(0);
		System.out.println(cnt);
	}
	private static void solve(int cur) {
		if (cur == N) {
			cnt++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (used1[i] || used2[i+cur] || used3[cur-i+N-1]) continue;
			used1[i] = true;
			used2[i+cur] = true;
			used3[cur-i+N-1] = true;
			solve(cur + 1);
			used1[i] = false;
			used2[i+cur] = false;
			used3[cur-i+N-1] = false;
		}
	}
}
