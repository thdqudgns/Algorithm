import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://st-lab.tistory.com/133
/**
 * 6으로 나눠지는 경우는 3으로 나누는 경우와 2로 나누는 경우 
 * 1을 빼는 경우 모두 재귀호출 하여 3가지 경우 중 최솟값으로 DP를 갱신해야 하고
 * 
 * 3으로만 나눠지는 경우는 3으로 나누는 경우와 1을 빼는 경우를 재귀호출 
 * 
 * 2로만 나눠지는 경우는 2로 나누는 경우와 1을 빼는 경우의 수를 재귀호출 
 * 
 * 그 외에는 1을 빼는 경우만 재귀호출을 해주면 된다.
 * 
 * 그리고 각 부분에 이전 재귀호출 중 최솟값에 1을 더한 값이 현재 N에 대한 최소연산 횟수가 된다.
 */
public class Main {
	static Integer[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new Integer[N+1];
		dp[0] = dp[1] = 0;
		
		System.out.println(recur(N));
	}
	static int recur(int N) {
		 
		if (dp[N] == null) {
			// 6으로 나눠지는 경우 
			if (N % 6 == 0) {
				dp[N] = Math.min(recur(N - 1), Math.min(recur(N / 3), recur(N / 2))) + 1;
			}
			// 3으로만 나눠지는 경우 
			else if (N % 3 == 0) {
				dp[N] = Math.min(recur(N / 3), recur(N - 1)) + 1;
			}
			// 2로만 나눠지는 경우 
			else if (N % 2 == 0) {
				dp[N] = Math.min(recur(N / 2), recur(N - 1)) + 1;
			}
			// 2와 3으로 나누어지지 않는 경우
			else {
				dp[N] = recur(N - 1) + 1;
			}
		}
		return dp[N];
	}
}