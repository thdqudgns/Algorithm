import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, cnt, max = 0;;
	static int[][] map;
	static Queue<int[]> q;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 비가 1~100 사이로 내리는 각각의 경우마다 안전영역의 개수를 세고, 가장 큰 값을 반환한다.
		for (int rain = 0; rain <= 100; rain++) {
			cnt = 0;
			for (int i = 0; i < N; i++) {
				Arrays.fill(visited[i], false);
			}
			q = new ArrayDeque<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > rain && !visited[i][j]) {
						cnt++;
						q.offer(new int[] {i, j});
						visited[i][j] = true;
						bfs(rain);
					}
				}
			}
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}

	private static void bfs(int rain) {
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int x = tmp[0];
			int y = tmp[1];
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx<0 || ny<0 || nx>=N || ny>=N) continue;
				if (map[nx][ny] <= rain || visited[nx][ny]) continue;
				visited[nx][ny] = true;
				q.offer(new int[] {nx, ny});
			}
		}
	}
}
