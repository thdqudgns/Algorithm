import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, M, sum;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			sum = 0;
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// ----------- 입력 끝 ---------------
			solve();
			sb.append(String.format("#%d %d\n",t, sum));
		}
		System.out.println(sb);
	}
	private static void solve() {
		for (int i = 0; i <= N - M; i++) {
			for (int j = 0; j <= N - M; j++) {
				int tmp = 0;
				for (int x = i; x < i+M; x++) {
					for (int y = j; y < j+M; y++) {
						tmp += map[x][y];
					}
				}
				sum = Math.max(sum, tmp);
			}
		}
	}
}
