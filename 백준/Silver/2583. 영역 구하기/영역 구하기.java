import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int M, N, K, cnt;
	static List<Integer> list;
	static Queue<int[]> q;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		K = sc.nextInt();
		map = new int[N+1][M+1];
		Arrays.fill(map[0], 1);
		for (int i = 0; i <= N; i++) {
			map[i][0] = 1;
		}
		for (int k = 0; k < K; k++) {
			int x1 = sc.nextInt() + 1;
			int y1 = sc.nextInt() + 1;
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			for (int i = x1; i <= x2; i++) {
				for (int j = y1; j <= y2; j++) {
					map[i][j] = 1;
				}
			}
		}
		list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] == 0) {
					cnt = 1;
					q = new ArrayDeque<>();
					q.offer(new int[] {i, j});
					map[i][j] = 1;
					bfs();
					list.add(cnt);
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for (int num : list) {
			System.out.print(num + " ");
		}
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int x = tmp[0];
			int y = tmp[1];
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx<0 || ny<0 || nx>N || ny>M) continue;
				if (map[nx][ny] == 1) continue;
				map[nx][ny] = 1;
				cnt++;
				q.offer(new int[] {nx, ny});
			}
		}
	}
}
