import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 어떤 수가 1이 되는 최소횟수는 정해져있다. -> 순수함수
 * 순수함수 -> DP의 메모이제이션을 사용하면 된다.
 * -> 규칙을 찾아보자
 * @author Hun
 *
 */
public class Main {
	static int[] dp = new int[1_000_001];
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Arrays.fill(dp, INF);
		
		dp[0] = 0;
		dp[1] = 0; // if (X <= 1) return dp[X];
		solve(N);
		
		System.out.println(dp[N]);
	}
	private static int solve(int X) {
		if (dp[X] != INF) return dp[X];
		if (X % 6 == 0) {
			dp[X] = Math.min(solve(X/3), Math.min(solve(X/2), solve(X-1))) + 1;
		} else if (X % 3 == 0) {
			dp[X] = Math.min(solve(X/3), solve(X-1)) + 1;
		} else if (X % 2 == 0) {
			dp[X] = Math.min(solve(X/2), solve(X-1)) + 1;
		} else {
			dp[X] = Math.min(dp[X], solve(X-1) + 1);
		}
		return dp[X];
	}
}
