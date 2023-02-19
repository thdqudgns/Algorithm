import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static int N, rg, rgb;
	static char[][] map1;
	static char[][] map2;
	static boolean[][] visit;
	static Queue<int[]> q;
	static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map1 = new char[N][N];
		map2 = new char[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				char c = s.charAt(j);
				map1[i][j] = c;
				if (c == 'G') {
					map2[i][j] = 'R';
				} else {
					map2[i][j] = c;
				}
			}
		}
		
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j]) continue;
				q = new ArrayDeque<>();
				q.offer(new int[] {i, j});
				visit[i][j] = true;
				rgb++;
				bfs1();
			}
		}
		
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j]) continue;
				q = new ArrayDeque<>();
				q.offer(new int[] {i, j});
				visit[i][j] = true;
				rg++;
				bfs2();
			}
		}
		
		System.out.println(rgb + " " + rg);
	}
	
	// 정상인
	private static void bfs1() {
		int[] s = q.peek();
		int a = s[0];
		int b = s[1];
		char start = map1[a][b];
		while (!q.isEmpty()) {
			int[] out = q.poll();
			int x = out[0];
			int y = out[1];
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if (visit[nx][ny] || map1[nx][ny] != start) continue;
				visit[nx][ny] = true;
				q.offer(new int[] {nx, ny});
			}
		}
	}
	
	// 적록색약인
	private static void bfs2() {
		int[] s = q.peek();
		int a = s[0];
		int b = s[1];
		char start = map2[a][b];
		while (!q.isEmpty()) {
			int[] out = q.poll();
			int x = out[0];
			int y = out[1];
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if (visit[nx][ny] || map2[nx][ny] != start) continue;
				visit[nx][ny] = true;
				q.offer(new int[] {nx, ny});
			}
		}
	}
}
