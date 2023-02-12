import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][M];
			
			int[] dx = {-1,0,1,0};
			int[] dy = {0,1,0,-1};
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}

			Queue<int[]> q = new ArrayDeque<>();
			boolean[][] visited = new boolean[N][M];
			
			/*
			System.out.println();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			*/
			
			int cnt = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 0 || visited[i][j]) continue;
					q.offer(new int[]{i, j});
					cnt++;
					while (!q.isEmpty()) {
						int[] out = q.poll();
						int x = out[0];
						int y = out[1];
						for (int l = 0; l < 4; l++) {
							int nx = x + dx[l];
							int ny = y + dy[l];
							if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
							if (visited[nx][ny] || map[nx][ny] == 0) continue;
							visited[nx][ny] = true;
							q.offer(new int[]{nx, ny});
						}
					}
				}
			}
			sb.append(cnt).append("\n");
		}//test_case
		System.out.println(sb);
	}//main
}
