//package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 외부와 접한 치즈는 사방 중에 0이 있다.
 * 갇혀있는 치즈는 어떻게 판별할 것인가
 */

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int cnt;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N][M];
		
		int ans = 0;
		while(isCheese()) {
			ans++;
			for(boolean[] arr : visited) {
				Arrays.fill(arr, false);
			}
			visited[0][0] = true;
			cnt = 0;
			dfs(0, 0);
		}
		System.out.println(ans);
		System.out.println(cnt);
	}
	
	private static void dfs(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
			if(visited[nr][nc]) continue;
			visited[nr][nc] = true;
			if (map[nr][nc] == 1) {
				map[nr][nc] = 2;
				cnt++;
			} else {
				dfs(nr, nc);
			}
		}
	}

	private static boolean isCheese() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 2) map[i][j] = 0;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) return true;
			}
		}
		return false;
	}
}
