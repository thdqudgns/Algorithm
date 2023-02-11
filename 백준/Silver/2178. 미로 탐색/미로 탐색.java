import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;	// map의 행과 열
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
		
		// 방문여부 2차원 배열을 원점에서의 거리를 확인하는 용도로 쓴다. 그래서 int[][]형으로
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], -1);
		}
		
		// 공백없이 입력되므로, String 클래스의 charAt(j)과 - '0'을 사용함
		for (int i = 0; i < N; i++) {
			String S = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = S.charAt(j) - '0';
			}
		}
		
		// 2. BFS 활용을 위한 설정
		q = new ArrayDeque<>();
		q.offer(new int[]{0, 0}); // 시작점이 (0, 0)이다.
		visited[0][0] = 0;	// 시작점은 거리가 0 
		// -> 근데 시작점도 거리에 포함한다고 했으므로 종점을 출력할 때 +1 해준다.
		
		bfs();	// 여기서는 방문처리하면서 거리 증가시킨다.
		System.out.println(visited[N-1][M-1]+1);
		// BFS 특성상, queue에 들어간 위치 순서대로 탐색을 하므로
		// 가장 먼저 방문처리를 하면 저절로 최솟값이 저장된다.
		// 그래서 최솟값을 비교해줄 필요가 없다.
		
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
