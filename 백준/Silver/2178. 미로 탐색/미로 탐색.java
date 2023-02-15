import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static int[][] dist;
	static Queue<int[]> q = new ArrayDeque<>();
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dist = new int[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], -1);
		}
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		q.offer(new int[]{0, 0});
		dist[0][0] = 1;
		bfs();
        // (N-1, M-1) 에 저장된 값을 반환하기만 하면된다.
		System.out.println(dist[N-1][M-1]);
	}

	private static void bfs() {
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int x = tmp[0];
			int y = tmp[1];
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if (dist[nx][ny] != -1 || map[nx][ny] != 1) continue;
				dist[nx][ny] = dist[x][y] + 1;
				q.offer(new int[] {nx, ny});
			}
		}
	}
}
