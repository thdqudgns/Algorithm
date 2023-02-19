import java.util.Scanner;

public class Main {
	static boolean[] used1, used2, used3;	// 열, 기울기가 1인 대각선, 기울기가 -1인 대각선
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
	private static void solve(int row) {
		if (row == N) {
			cnt++;
			return;
		}
		for (int col = 0; col < N; col++) {
			if (used1[col] || used2[col + row] || used3[row - col + N - 1]) continue;
			// 퀸을 놓은 경우를 체크한다.
			used1[col] = true;
			used2[col + row] = true;	// 기울기가 1인 대각선 위치는 row와 col의 합이다.
			used3[row - col + N - 1] = true;	// 기울기가 -1인 대각선 위치는 row와 col의 차인데, 
			// 0행 (N-1)열의 경우, -(N-1)이 되므로 뒤에 +(N-1)을 해주어 index가 음수로 가지 않게 했다.
			// 재귀
			solve(row + 1);
			// 퀸을 다시 거둔다.
			used1[col] = false;
			used2[col + row] = false;
			used3[row - col + N - 1] = false;
		}
	}
}
