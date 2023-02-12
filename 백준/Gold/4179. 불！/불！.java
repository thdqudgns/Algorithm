//package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static String[][] map;
	static int[][] jihunMap, fireMap;
	static Queue<int[]> fireQ, jihunQ;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new String[N][M];
		fireMap = new int[N][M];
		jihunMap = new int[N][M];
		fireQ = new ArrayDeque<>();
		jihunQ = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			Arrays.fill(fireMap[i], -1);
			Arrays.fill(jihunMap[i], -1);
		}
		for (int i = 0; i < N; i++) {
			String S = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = String.valueOf(S.charAt(j));
				if (map[i][j].equals("F")) {
					fireMap[i][j] = 0;
					fireQ.offer(new int[]{i, j});
				}
				if (map[i][j].equals("J")) {
					jihunMap[i][j] = 0;
					jihunQ.offer(new int[]{i, j});
				}
			}
		}
		/*
		System.out.println("map");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("fireMap");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(fireMap[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("jihunMap");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(jihunMap[i][j] + " ");
			}
			System.out.println();
		}
		*/
		fireBFS();
		//jihunBFS();
		while(!jihunQ.isEmpty()) {
			int[] position = jihunQ.poll();
			int x = position[0];
			int y = position[1];
			for (int dir = 0; dir < 4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				// 범위를 벗어났다면 탈출 성공!!
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					System.out.println(jihunMap[x][y] + 1);
					return;
				}
				// 범위 안에서, 지훈이가 이미 방문한 곳이거나, map상 벽이 있는 곳이라면 넘어간다.
				if (jihunMap[nx][ny] >= 0 || map[nx][ny].equals("#")) continue;
				// 불이 번진 곳인데(!= -1), 지훈이가 이동한 날짜보다 불이 먼저 번졌거나(fireMap이 작을 때), 똑같은 날에 지훈이와 불이 만난다면(같을 때)
				// 갈 수 없는 곳이므로 pass
				if (fireMap[nx][ny] != -1 && jihunMap[x][y]+1 >= fireMap[nx][ny]) continue;
				jihunMap[nx][ny] = jihunMap[x][y] + 1;
				jihunQ.offer(new int[]{nx, ny});
			}
		}
		System.out.println("IMPOSSIBLE");
		/*
		System.out.println("fireMap");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(fireMap[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("jihunMap");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(jihunMap[i][j] + " ");
			}
			System.out.println();
		}
		*/
		/*
		boolean exist = false;
		int day = 1002;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i != 0 && i != N-1) {
					if (j != 0 && j != M-1) continue;
				}
				if (jihunMap[i][j] < fireMap[i][j]) {
					int tmp = jihunMap[i][j];
					exist = true;
					day = Math.min(day, tmp);
				}
			}
		}
		if (exist) {
			System.out.println(day+1);
		} else {
			System.out.println("IMPOSSIBLE");
		}
		*/
	}
	private static void fireBFS() {
		while(!fireQ.isEmpty()) {
			int[] position = fireQ.poll();
			int x = position[0];
			int y = position[1];
			for (int dir = 0; dir < 4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if (fireMap[nx][ny] >= 0 || map[nx][ny].equals("#")) continue;
				fireMap[nx][ny] = fireMap[x][y] + 1;
				fireQ.offer(new int[]{nx, ny});
			}
		}
	}
	/*
	private static void jihunBFS() {
		while(!jihunQ.isEmpty()) {
			int[] position = jihunQ.poll();
			int x = position[0];
			int y = position[1];
			for (int dir = 0; dir < 4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if (jihunMap[nx][ny] >= 0 || map[nx][ny].equals("#")) continue;
				jihunMap[nx][ny] = jihunMap[x][y] + 1;
				jihunQ.offer(new int[]{nx, ny});
			}
		}
	}
	*/
}
