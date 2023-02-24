import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// CCTV는 CCTV를 통과할 수 있다.
public class Main {
	
	static class CCTV {
		int r, c, num;
		public CCTV(int r, int c, int num) {
			this.r = r;
			this.c = c;
			this.num = num;
		}
		@Override
		public String toString() {
			return "CCTV [r=" + r + ", c=" + c + ", num=" + num + "]";
		}
	}
	static List<CCTV> cctvs = new ArrayList<>();
	static int N, M, size, min = Integer.MAX_VALUE;
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String in = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = in.charAt(j*2);
				if (map[i][j] != '0' && map[i][j] != '6') {
					cctvs.add(new CCTV(i, j, map[i][j]-'0'));
				}
			}
		}
		size = cctvs.size(); //cctv의 개수
		dfs(0, map);
		System.out.println(min);
	}

	private static void dfs(int idx, char[][] map) {
		if (idx == size) {
			int tmp = 0;
			for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) if (map[i][j] == '0') tmp++;
			min = Math.min(min, tmp);
			return;
		}

		if (cctvs.get(idx).num == 1) {
			for (int i = 1; i <= 4; i++) {
				dfs(idx + 1, change1(idx, i, map));
			}
		} else if (cctvs.get(idx).num == 2) {
			for (int i = 1; i <= 2; i++) {
				dfs(idx + 1, change2(idx, i, map));
			}
		} else if (cctvs.get(idx).num == 3) {
			for (int i = 1; i <= 4; i++) {
				dfs(idx + 1, change3(idx, i, map));
			}
		} else if (cctvs.get(idx).num == 4) {
			for (int i = 1; i <= 4; i++) {
				dfs(idx + 1, change4(idx, i, map));
			}
		} else if (cctvs.get(idx).num == 5) {
			dfs(idx + 1, change5(idx, map));
		}
		
	}
	
	// 1: 우, 2: 하, 3: 좌, 4: 상
	private static char[][] change1(int idx, int num, char[][] map) {
		int r = cctvs.get(idx).r;
		int c = cctvs.get(idx).c;
		char[][] tmpMap = new char[N][M];
		for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) tmpMap[i][j] = map[i][j];
		switch (num) {
		case 1:
			c++;
			while (c < M && tmpMap[r][c] != '6') tmpMap[r][c++] = '#';
			break;
		case 2:
			r++;
			while (r < N && tmpMap[r][c] != '6') tmpMap[r++][c] = '#';
			break;
		case 3:
			c--;
			while (c >= 0 && tmpMap[r][c] != '6') tmpMap[r][c--] = '#';
			break;
		case 4:
			r--;
			while (r >= 0 && tmpMap[r][c] != '6') tmpMap[r--][c] = '#';
			break;
		}
		return tmpMap;
	}
	// 1: 좌우, 2: 상하 
	private static char[][] change2(int idx, int num, char[][] map) {
		int r = cctvs.get(idx).r;
		int c = cctvs.get(idx).c;
		char[][] tmpMap = new char[N][M];
		for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) tmpMap[i][j] = map[i][j];
		switch (num) {
		case 1:
			int c1 = c, c2 = c;
			c1--; c2++;
			while(c1 >= 0 && tmpMap[r][c1] != '6') tmpMap[r][c1--] = '#';
			while (c2 < M && tmpMap[r][c2] != '6') tmpMap[r][c2++] = '#';
			break;
		case 2:
			int r1 = r, r2 = r;
			r1--; r2++;
			while(r1 >= 0 && tmpMap[r1][c] != '6') tmpMap[r1--][c] = '#';
			while(r2 < N && tmpMap[r2][c] != '6') tmpMap[r2++][c] = '#';
			break;
		}
		return tmpMap;
	}
	// 1: ㄴ, 2: ┌, 3: ㄱ 4: ┘ 
	private static char[][] change3(int idx, int num, char[][] map) {
		int r = cctvs.get(idx).r;
		int c = cctvs.get(idx).c;
		char[][] tmpMap = new char[N][M];
		for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) tmpMap[i][j] = map[i][j];
		switch (num) {
		case 1:
			int r1 = r, c1 = c;
			r1--; c1++;
			while (r1 >= 0 && tmpMap[r1][c] != '6') tmpMap[r1--][c] = '#';
			while (c1 < M && tmpMap[r][c1] != '6') tmpMap[r][c1++] = '#';
			break;
		case 2:
			int r2 = r, c2 = c;
			r2++; c2++;
			while (r2 < N && tmpMap[r2][c] != '6') tmpMap[r2++][c] = '#';
			while (c2 < M && tmpMap[r][c2] != '6') tmpMap[r][c2++] = '#';
			break;
		case 3:
			int r3 = r, c3 = c;
			r3++; c3--;
			while (r3 < N && tmpMap[r3][c] != '6') tmpMap[r3++][c] = '#';
			while (c3 >= 0 && tmpMap[r][c3] != '6') tmpMap[r][c3--] = '#';
			break;
		case 4:
			int r4 = r, c4 = c;
			r4--; c4--;
			while (r4 >= 0 && tmpMap[r4][c] != '6') tmpMap[r4--][c] = '#';
			while (c4 >= 0 && tmpMap[r][c4] != '6') tmpMap[r][c4--] = '#';
			break;
		}
		return tmpMap;
	}
	// 1: ㅗ, 2: ㅏ, 3: ㅜ, 4: ㅓ
	private static char[][] change4(int idx, int num, char[][] map) {
		char[][] tmpMap = new char[N][M];
		for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) tmpMap[i][j] = map[i][j];
		switch (num) {
		case 1:
			tmpMap = change2(idx, 1, tmpMap);
			tmpMap = change1(idx, 4, tmpMap);
			break;
		case 2:
			tmpMap = change2(idx, 2, tmpMap);
			tmpMap = change1(idx, 1, tmpMap);
			break;
		case 3:
			tmpMap = change2(idx, 1, tmpMap);
			tmpMap = change1(idx, 2, tmpMap);
			break;
		case 4:
			tmpMap = change2(idx, 2, tmpMap);
			tmpMap = change1(idx, 3, tmpMap);
			break;
		}
		return tmpMap;
	}
	// ┼
	private static char[][] change5(int idx, char[][] map) {
		int r = cctvs.get(idx).r;
		int c = cctvs.get(idx).c;
		char[][] tmpMap = new char[N][M];
		for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) tmpMap[i][j] = map[i][j];
		int r1 = r, r2 = r, c1 = c, c2 = c;
		r1--; r2++; c1--; c2++;
		while(r1 >= 0 && tmpMap[r1][c] != '6') tmpMap[r1--][c] = '#';
		while(r2 < N && tmpMap[r2][c] != '6') tmpMap[r2++][c] = '#';
		while(c1 >= 0 && tmpMap[r][c1] != '6') tmpMap[r][c1--] = '#';
		while(c2 < M && tmpMap[r][c2] != '6') tmpMap[r][c2++] = '#';
		return tmpMap;
	}
}
