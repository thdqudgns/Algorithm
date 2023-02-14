import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N, M, max;
	static int[] snack;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			max = -1;
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 주어지는 과자 개수
			N = Integer.parseInt(st.nextToken());
			// 무게 리미트
			M = Integer.parseInt(st.nextToken());
			snack = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				snack[j] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					int sum = snack[i] + snack[j];
					if(sum <= M)
						max = Math.max(sum, max);
				}
			}
			
			sb.append("#" + t + " ").append(max + "\n");
		} // test_case
		System.out.println(sb);
	}
}
