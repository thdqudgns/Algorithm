import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> q;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static List<Integer> apart = new ArrayList<Integer>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String S = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = S.charAt(j) - '0';
			}
		}

		/*
		System.out.println();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		*/
		int cnt = 0;
		q = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				//집이 없는 곳이거나, 이미 방문한 곳이라면 넘어간다.
				if(map[i][j] == 0 || visited[i][j]) continue;
				// 집이 있는데, 아직 방문하지 않았다면 큐에 넣는다.
				q.offer(new int[]{i, j});
				visited[i][j] = true;    // ★이걸 안해서 틀렸었네..
				cnt++;	// 총 단지수
				bfs();
			}
		}
		System.out.println(cnt);
		Collections.sort(apart);
		apart.forEach(System.out::println);
	}//main
	private static void bfs() {
		int cntApart = 0;
		// 큐에 값이 있다면 탐색을 실시한다.
		while (!q.isEmpty()) {
			// 큐에서 값을 빼내서, 좌표를 저장함
			int[] out = q.poll();
			cntApart += 1; // 단지 내 아파트 수
			int x = out[0];
			int y = out[1];
			// 사방탐색
			for (int l = 0; l < 4; l++) {
				int nx = x + dx[l];
				int ny = y + dy[l];
				//범위에 맞지 않으면 pass
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				//이미 방문했거나, 아파트가 없는 곳이라면 pass
				if (visited[nx][ny] || map[nx][ny] == 0) continue;
				visited[nx][ny] = true; // 방문처리
				q.offer(new int[]{nx, ny}); //새롭게 탐색을 실시하기 위해 큐에 넣는다.
			}
		}
		apart.add(cntApart);
	}
}
