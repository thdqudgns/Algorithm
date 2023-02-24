import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

// 적록색약: R=G
// 적록색약이 아닌 사람이 봤을 때의 구역 수, 적록색약인 사람이 봤을 때의 구역 수
public class Main {

	static char[][] map1, map2;
	static int N, cnt1, cnt2;
	static Queue<int[]> q1, q2;
	static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map1 = new char[N][N];
		map2 = new char[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map1[i][j] = s.charAt(j); 
				if (map1[i][j] == 'G') {
					map2[i][j] = 'R';
				} else {
					map2[i][j] = map1[i][j];
				}
			}
		}
		q1 = new ArrayDeque<>();
		q2 = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map1[i][j] != '0') {
					q1.offer(new int[] {i, j});
					bfs1();
					cnt1++;
				}
				if (map2[i][j] != '0') {
					q2.offer(new int[] {i, j});
					bfs2();
					cnt2++;
				}
			}
		}
		System.out.println(cnt1 + " " + cnt2);
	}

	private static void bfs1() {
		char start = map1[q1.peek()[0]][q1.peek()[1]];
		map1[q1.peek()[0]][q1.peek()[1]] = '0';
		while(!q1.isEmpty()) {
			int[] tmp = q1.poll();
			int x = tmp[0];
			int y = tmp[1];
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx>=N || ny < 0 || ny>=N) continue;
				if (map1[nx][ny] != start) continue;
				map1[nx][ny] = '0';
				q1.offer(new int[] {nx, ny});
			}
		}
	}
	private static void bfs2() {
		char start = map2[q2.peek()[0]][q2.peek()[1]];
		map2[q2.peek()[0]][q2.peek()[1]] = '0';
		while(!q2.isEmpty()) {
			int[] tmp = q2.poll();
			int x = tmp[0];
			int y = tmp[1];
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx>=N || ny < 0 || ny>=N) continue;
				if (map2[nx][ny] != start) continue;
				map2[nx][ny] = '0';
				q2.offer(new int[] {nx, ny});
			}
		}
	}
}
