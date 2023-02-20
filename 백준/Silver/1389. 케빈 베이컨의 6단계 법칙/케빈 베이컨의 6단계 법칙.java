import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, R, min = Integer.MAX_VALUE;	// number, relationship
	static int[][] map; 
	static int[] kebin, tmp; 
	static boolean[] visit;
	static Queue<Integer> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		// 들어오는 순서대로 저장해주기 위해 N+1로 생성한다.
		map = new int[N+1][N+1];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = map[y][x] = 1;	// 간선을 2차원 int 배열로 저장
		}
		visit = new boolean[N+1];
		tmp = new int[N+1];
		kebin = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			Arrays.fill(visit, false);
			Arrays.fill(tmp, 0);
			q = new ArrayDeque<>();
			q.offer(i);
			visit[i] = true;
			tmp[i] = 0;
			bfs(i);
		}
		for (int i = 1; i <= N; i++) {
			if (kebin[i] == min) {
				System.out.print(i);
				break;
			}
		}
	}
	private static void bfs(int index) {
		while(!q.isEmpty()) {
			int i = q.poll();
			for (int j = 1; j < N+1; j++) {
				if (visit[j] || map[i][j] == 0) continue;
				q.offer(j);
				visit[j] = true;
				tmp[j] = tmp[i] + 1;
			}
		}
		int sum = Arrays.stream(tmp).sum();
		min = Math.min(min, sum);
		kebin[index] = sum;
	}
}
