import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, L, max;
	static int[][] combi;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			max = 0;
			combi = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				combi[i][0] = Integer.parseInt(st.nextToken());
				combi[i][1] = Integer.parseInt(st.nextToken());
			}
			subset();
			sb.append("#" + t + " ").append(max + "\n");
		}
		System.out.println(sb);
	}
	
	private static void subset() {
		for (int i = 0; i < (1<<N); i++) {
			int sumTaste = 0;
			int sumKcal = 0;
			for (int j = 0; j < N; j++) {
				if((i & (1<<j)) == 0) continue;
				sumTaste += combi[j][0];
				sumKcal += combi[j][1];
			}
			if (sumKcal <= L && sumTaste >= max) {
				max = sumTaste;
			}
		}
	}
}
