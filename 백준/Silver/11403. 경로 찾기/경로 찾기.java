import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, start;
	static int[][] map,result;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		map = new int[N+1][N+1];
		result = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 끝
		for (int i = 1; i <= N; i++) {
			visit = new boolean[N+1];
			start = i;
			dfs(i);
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				sb.append(result[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	private static void dfs(int i) {
		for (int j = 1; j <= N; j++) {
			if (visit[j]) continue;
			if (map[i][j] == 1) {
				visit[j] = true;
				result[start][j] = 1;
				dfs(j);
			}
		}
	}
}
