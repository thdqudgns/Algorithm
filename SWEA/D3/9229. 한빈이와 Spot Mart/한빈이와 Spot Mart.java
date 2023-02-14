import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N, M, max;
	static int[] snack, result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= T; i++) {
			max = -1;
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 주어지는 과자 개수
			N = Integer.parseInt(st.nextToken());
			// 무게 리미트
			M = Integer.parseInt(st.nextToken());
			snack = new int[N];
			result = new int[2];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				snack[j] = Integer.parseInt(st.nextToken());
			}
			solve(0, 0);
			sb.append("#" + i + " ").append(max + "\n");
		} // test_case
        System.out.println(sb);
	}
	private static void solve(int cnt, int start) {
		if (cnt == 2) {
			int sum = Arrays.stream(result).sum();
			if (sum <= M) {
				max = Math.max(sum, max);
			}
			return;
		}
		for (int i = start; i < N; i++) {
			result[cnt] = snack[i];
			solve(cnt + 1, i + 1);
		}
	}
}
