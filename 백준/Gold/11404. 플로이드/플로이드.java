import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		final int INF = 10_000_000; 
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) map[i][j] = INF;
			}
			map[i][i] = 0;
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[s-1][e-1] = Math.min(map[s-1][e-1], c);
		}
		
		
		for (int i = 0; i < N; i++) { // 경유지
			for (int j = 0; j < N; j++) { // 출발지
				if (i == j) continue;
				for (int k = 0; k < N; k++) { // 도착지
					if (i == k || j == k) continue;
					int tmp = map[j][i] + map[i][k];
					if (tmp < map[j][i] && tmp < map[i][k]) tmp = INF;
					map[j][k] = Math.min(tmp, map[j][k]);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == INF) sb.append("0 ");
				else sb.append(map[i][j] + " ");
			}
			if (i != N-1)
				sb.append("\n");
		}
		System.out.print(sb);
	}
}
