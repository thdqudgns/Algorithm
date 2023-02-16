import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, T, S, cnt;
	static int[][] map;
	static boolean[] visit;
	static Queue<Integer> q;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		visit = new boolean[N+1];
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
			map[y][x] = 1;
		}
		dfs(S);
		System.out.println();
		Arrays.fill(visit, false);
		bfs();
	}
	private static void dfs(int n) {
		visit[n] = true;
		System.out.print(n + " ");
		for (int i = 1; i <= N; i++) {
			if (visit[i] || map[n][i] != 1 || map[i][n] != 1) continue;
			dfs(i);
		}
	}
	private static void bfs() {
		q = new ArrayDeque<Integer>();
		q.offer(S);
		visit[S] = true;
		while(!q.isEmpty()) {
			int num = q.poll();
			System.out.print(num + " ");
			for (int i = 1; i <= N; i++) {
				if (visit[i] || map[num][i] != 1 || map[i][num] != 1) continue;
				visit[i] = true;
				q.offer(i);
			}
		}
	}
}
