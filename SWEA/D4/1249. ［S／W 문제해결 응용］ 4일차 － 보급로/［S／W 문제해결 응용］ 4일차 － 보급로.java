import java.io.*;
import java.util.*;

public class Solution {
	static int N, ans;
	static int[][] map, dis;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static Queue<int[]> q;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()), t = 0;
		StringBuilder sb = new StringBuilder();
		
		while (t++ < T) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			dis = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}
			for (int i = 0; i < N; i++) {
				Arrays.fill(dis[i], Integer.MAX_VALUE);
			}
			
			// BFS 로 진행하면서, 해당 (r,c) 까지 갈 수 있는 최소값을 저장한다.
			q = new ArrayDeque<>();
			q.offer(new int[] {0, 0});
			dis[0][0] = 0;
			bfs();
			sb.append(String.format("#%d %d\n", t, dis[N-1][N-1]));
		}
		System.out.print(sb);
	}
	private static void bfs() {
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr<0 || nc<0 || nr>=N || nc>=N) continue;
				int num = map[nr][nc] + dis[r][c];
				if (dis[nr][nc] > num) {
					dis[nr][nc] = num;
					q.offer(new int[] {nr, nc});
				}
			}
		}
	}
}