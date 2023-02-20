import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String in = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = in.charAt(j) - '0';
			}
		}
		solve(0, 0, N);
		System.out.println(sb);
	}

	private static void solve(int r, int c, int n) {
		int start = map[r][c];	// 시작지점의 숫자를 저장하여 비교할 때 사용함
		boolean all = true;		// 모두가 같다면, start를 sb에 추가하고 끝낸다.
		ALL:
		for (int i = r; i < r+n; i++) {
			for (int j = c; j < c+n; j++) {
				if (map[i][j] != start) {
					all = false;	// n*n이 통일되지 않았다면
					break ALL;		// 2중 반복문을 멈추고, 4분할 탐색을 실시한다.
				}
			}
		}
		n /= 2;	// 먼저 n을 2로 나누고
		if (all) {
			sb.append(start);		// 모두 통일된 숫자라면 start만 저장하고 끝낸다.
		} else {					// 4분할 탐색을 실시한다.
			sb.append("(");			// 4분할 탐색을 시작할 때만 괄호를 넣어주면 된다.
			solve(r, c, n);
			solve(r, c+n, n);
			solve(r+n, c, n);
			solve(r+n, c+n, n);
			sb.append(")");			// 4분할 탐색이 끝났다면, 괄호를 닫아준다.
		}
	}
}