import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int w, h, cnt;
	static int[][] map;
	static Queue<int[]> q;
	static boolean[][] visited;
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0) break;
			cnt = 0;
			map = new int[h][w];
			visited = new boolean[h][w];
			
			q = new ArrayDeque<>();
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 0 || visited[i][j]) continue;
						q.offer(new int[] {i, j});
						visited[i][j] = true;
						cnt++;
						bfs();
				}
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int x = tmp[0];
			int y = tmp[1];
			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
				if (map[nx][ny] == 0 || visited[nx][ny]) continue;
				q.offer(new int[] {nx, ny});
				visited[nx][ny] = true;
			}
		}
	}
}
