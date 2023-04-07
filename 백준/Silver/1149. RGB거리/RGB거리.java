import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
	static int N;
	static int[][] map;
	static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][3]; // N은 각 집의 번호, 3은 각 RGB 색상별 비용
		dp = new int[N+1][3];
		for (int i = 1; i <= N; i++) {
			map[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			// System.out.println(Arrays.toString(map[i])); 입력 체크
		}
		/*
		 * 조건 : 
		 * 1. 인접한 두 집의 색상이 달라야 한다.
		 * 2. 모든 집을 칠하는 최소비용을 구해야 한다. -> DP 
		 */
		System.out.print(Math.min(solve(N, 0), Math.min(solve(N, 1), solve(N, 2))));
	}
	private static int solve(int n, int rgb) {
		if (n == 0) return 0;
		if (dp[n][rgb] == 0) {
			int a = -1, b = -1;
			for (int i = 0; i < 3; i++) {
				if (i == rgb) continue;
				if (a == -1) {
					a = i;
					continue;
				} else {
					b = i;
				}
			}
			dp[n][rgb] = map[n][rgb] + Math.min(solve(n-1, a), solve(n-1, b));
		}
		return dp[n][rgb];
	}
}
