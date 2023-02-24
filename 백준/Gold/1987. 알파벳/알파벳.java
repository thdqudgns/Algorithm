import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C, max;
	static char[][] map;
	static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		int flag = 1<<(map[0][0]-'A');
		dfs(1, flag, 0, 0);
		System.out.println(max);
	}
	
	private static void dfs(int cnt, int flag, int r, int c) {
		max = Math.max(max, cnt);
		for (int i = 0; i < 4; i++) {
			int nx = r + dx[i];
			int ny = c + dy[i];
			if (nx<0 || nx>=R || ny<0 || ny>=C) continue;
			if ((flag & 1<<(map[nx][ny]-'A')) != 0) continue;
			dfs(cnt + 1, flag | 1<<(map[nx][ny]-'A'), nx, ny);
		}
	}
}
