import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int zero, one;
	static int[] dp = new int[41];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		// 피보나치 dp 메모리제이션
		dp[1] = 1;
		for (int i = 2; i < 41; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				sb.append("1 0\n");
				continue;
			}
			// dp[n]이 1을 호출한 횟수고, dp[n-1]이 0을 호출한 횟수다.
			sb.append(dp[n-1] + " " + dp[n] + "\n");
		}
		System.out.println(sb);
	}
}
