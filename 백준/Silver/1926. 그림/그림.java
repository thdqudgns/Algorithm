import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;	// map의 행과 열
	static int cnt = 0, maxArea = 0, area;	// 그림의 개수, 가장 넓은 영역, bfs마다 영역검토
	static int[][] map;	// map
	static boolean[][] visited; // 방문여부
	static int[] dx = {-1, 0, 1, 0};	// 사방탐색
	static int[] dy = {0, 1, 0, -1};	// 사방탐색
	static Queue<int[]> q;	// BFS확인
	public static void main(String[] args) throws IOException {
		// 1. 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];	// 미방문: false, 방문: true
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 2. BFS 활용을 위한 설정
		q = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] || map[i][j] == 0) continue;
				// 아직 방문하지 않은, 1인 부분이라면 다시 bfs를 실시한다. - 동시에 cnt 증가
				q.offer(new int[]{i, j});
				visited[i][j] = true;
				cnt++;
				area = 0;
				bfs();	// 여기서는 방문처리와, 최대넓이 확인만 하자
			}
		}
		System.out.println(cnt);
		System.out.println(maxArea);
	}
	
	private static void bfs() {
		while(!q.isEmpty()) {
			area++;	// 시작점부터 넓이 포함, q가 비어있지 않다는 것 == 해당 영역이 미방문한 1이라는 뜻
			int[] position = q.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nx = position[0] + dx[dir];
				int ny = position[1] + dy[dir];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if (visited[nx][ny] || map[nx][ny] != 1) continue;
				visited[nx][ny] = true;
				q.offer(new int[]{nx, ny});
			}
		}
		maxArea = Math.max(maxArea, area);
	}
}
