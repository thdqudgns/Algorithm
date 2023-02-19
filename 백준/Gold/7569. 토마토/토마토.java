import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, H, ans = 0;	// map의 행과 열, 날짜 카운트
	static int[][][] map;	// map
	static int[][][] dist; // 방문여부
	static int[] dh = {-1, 0, 0, 0, 0, 1};	// 육방탐색
	static int[] dx = {0, -1, 0, 1, 0, 0};	// 육방탐색
	static int[] dy = {0, 0, 1, 0, -1, 0};	// 육방탐색
	static Queue<int[]> q;	// BFS확인
	public static void main(String[] args) throws IOException {
		// 1. 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][N][M];
		dist = new int[H][N][M];
		q = new ArrayDeque<>();
		
		// 2. 입력과 동시에, BFS 활용을 위한 설정
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[k][i][j] = Integer.parseInt(st.nextToken());
					if (map[k][i][j] == 1) q.offer(new int[]{k, i, j});	// 익은 토마토의 위치를 큐에 넣는다.
					if (map[k][i][j] == 0) dist[k][i][j] = -1;	// dist[i][j] == -1 : 익지 않은 토마토를 -1로 저장
					// (dist[i][j] >= 0 && map[i][j] >= 1) 이면 익은 토마토
				}
			}
		}
		bfs();
		System.out.println(ans);
	}
	
	/*
	 * 첫째날 : 기존에 익은 토마토들을 시작점으로, 사방의 익지않은 토마토들을 익힌다. 익은 토마토들은 dist[nx][ny] = 0 + 1 이 된다.
	 * 둘째날 : 전날에 익은 토마토들을 시작점으로, 사방의 익지않은 토마토들을 익힌다. 익은 토마토들은 dist[nx][ny] = 1 + 1 이 된다.
	 * 셋째날 : 전날에 익은 토마토들을 시작점으로, 사방의 익지않은 토마토들을 익힌다. 익은 토마토들은 dist[nx][ny] = 2 + 1 이 된다.
	 * 처음에 익은 토마토들의 위치를 일괄 큐에 저장했으므로, 첫날의 토마토들을 모두 확인하고 둘째날로 넘어간다.
	 * 큐의 특성상 들어온 순서대로 빼내면서 일을 진행하기 때문에 각 dist에는 저장될 수 있는 최솟값이 저절로 저장된다.
	 * 
	 * 큐에 저장된 값들을 모두 빼낸 후에는, 다시 dist를 전체 순회하면서,
	 * -1이 있으면 익지 않는 토마토가 있으므로 -1을 출력하고
	 * 그 외에는 최댓값을 출력하면 된다.
	 */
	private static void bfs() {
		while(!q.isEmpty()) {
			int[] position = q.poll();
			for (int dir = 0; dir < 6; dir++) {
				int nh = position[0] + dh[dir];
				int nx = position[1] + dx[dir];
				int ny = position[2] + dy[dir];
				if (nh < 0 || nh >= H || nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if (dist[nh][nx][ny] >= 0) continue;	// 익지 않은 토마토가 아니라면 pass
				dist[nh][nx][ny] = dist[position[0]][position[1]][position[2]] + 1;	// 며칠이 지났는지 check한다.
				q.offer(new int[]{nh, nx, ny});
			}
		}
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (dist[k][i][j] == -1) {
						ans = -1;
						return;
					}
					ans = Math.max(ans, dist[k][i][j]);
				}
			}
		}
	}
}