import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;	// map의 행과 열
	static int cnt = 0, maxArea = 0, area;	// 그림의 개수, 가장 넓은 영역, bfs마다 영역검토
	static int[][] map;	// map
	static int[][] visited; // 방문여부
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
		visited = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], -1);
		}
		
		for (int i = 0; i < N; i++) {
			String S = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = S.charAt(j) - '0';
			}
		}
		
		// 2. BFS 활용을 위한 설정
		q = new ArrayDeque<>();
		
		q.offer(new int[]{0, 0});
		visited[0][0] = 0;
		bfs();	// 여기서는 방문처리와, 최대넓이 확인만 하자
		System.out.println(visited[N-1][M-1]+1);
	}
	
	private static void bfs() {
		while(!q.isEmpty()) {
			int[] position = q.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nx = position[0] + dx[dir];
				int ny = position[1] + dy[dir];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if (visited[nx][ny] != -1 || map[nx][ny] != 1) continue;
				visited[nx][ny] = visited[position[0]][position[1]]+1;
				q.offer(new int[]{nx, ny});
			}
		}
	}
}
