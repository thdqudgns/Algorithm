//package solve;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, ans;
	static int sr, sc, er, ec;
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> q;
	static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt(), t = 0;
		StringBuilder sb = new StringBuilder();
		while(t++ < T) {
			N = in.nextInt();
			sr = in.nextInt(); sc = in.nextInt();
			er = in.nextInt(); ec = in.nextInt();
			map = new int[N][N]; visited = new boolean[N][N];
			q = new ArrayDeque<>();
			q.offer(new int[] {sr, sc});
			visited[sr][sc] = true;
			while (!visited[er][ec]) {
				int[] tmp = q.poll();
				int x = tmp[0];
				int y = tmp[1];
				for (int d = 0; d < 8; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if (nx<0 || ny<0 || nx>=N || ny>=N) continue;
					if (visited[nx][ny]) continue;
					map[nx][ny] += map[x][y] + 1;
					visited[nx][ny] = true;
					q.offer(new int[] {nx, ny});
				}
			}
			ans = map[er][ec];
			sb.append(ans + "\n");
			ans = 0; 
		}
		System.out.println(sb);
	}
}
