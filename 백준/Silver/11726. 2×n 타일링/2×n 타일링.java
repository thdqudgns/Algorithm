import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// dp 설정하기
		long[] dp = new long[1001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		for (int i = 4; i < 1001; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%10_007;
		}
		System.out.println(dp[N]);
	}
}
