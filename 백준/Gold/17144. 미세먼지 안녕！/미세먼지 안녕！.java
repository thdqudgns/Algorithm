import java.util.*;
import java.io.*;

public class Main {
	static int R, C, T, ans;
	static int[][] map, tmp;
	static int cleaner;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			if (map[i][0] == -1) cleaner = i; // 공기청정기의 아래행이 저장된다.
		}
		
		for (int t = 0; t < T; t++) {
			// tmp는 매번 초기화시켜주어야 한다.
			tmp = new int[R][C]; // +- 할 값들 임시저장 -> 각 턴의 마지막에 map으로 다시 더해주기
			dust();
			wind(cleaner-1, cleaner);
			//check();
			//System.out.println();
		}
		for (int r = 0; r < R; r++) {
			ans += Arrays.stream(map[r]).sum();
		}
		System.out.print(ans+2); // 청정기값으로 빠진 -2를 마지막에 더해준다.
	}
	/**
	 * 출력 확인하는 메소드
	 */
	private static void check() {
		for (int r = 0; r < R; r++) {
			System.out.println(Arrays.toString(map[r]));
		}
	}
	/**
	 * 미세먼지가 확산된다.
	 */
	private static void dust() {
		// 미세먼지 퍼뜨리기
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] < 5) continue;
				expand(r, c, map[r][c]);
			}
		}
		// tmp값 합치기
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				map[r][c] += tmp[r][c];
			}
		}
	}
	/**
	 * 미세먼지가 확산 되기 전에, 얼마나 확산되어야 하는지 tmp에 저장한다.
	 */
	private static void expand(int r, int c, int weight) {
		int out = 0;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr<0 || nc<0 || nr>=R || nc>=C || map[nr][nc] == -1) continue;
			out += weight/5;
			tmp[nr][nc] += weight/5;
		}
		tmp[r][c] -= out;
	}
	/**
	 * 공기청정기에 의해 먼지가 이동된다.
	 */
	private static void wind(int row1, int row2) {
		upCycle(row1);
		downCycle(row2);
	}
	private static void upCycle(int row) {
		// 역방향 당기기
		for (int r = row; r >= 1; r--) {
			map[r][0] = map[r-1][0]; // row ~ 1
		}
		for (int c = 0; c <= C-2; c++) {
			map[0][c] = map[0][c+1]; // 0 ~ C-2
		}
		for (int r = 0; r <= row-1; r++) {
			map[r][C-1] = map[r+1][C-1]; // 0 ~ row-1
		}
		for (int c = C-1; c >= 2; c--) {
			map[row][c] = map[row][c-1]; // C-1 ~ 2
		}
		map[row][0] = -1;
		map[row][1] = 0;
	}
	private static void downCycle(int row) {
		// 역방향 당기기
		for (int r = row; r <= R-2; r++) {
			map[r][0] = map[r+1][0]; // row ~ R-2
		}
		for (int c = 0; c <= C-2; c++) {
			map[R-1][c] = map[R-1][c+1]; // 0 ~ C-2
		}
		for (int r = R-1; r >= row+1; r--) {
			map[r][C-1] = map[r-1][C-1]; // R-1 ~ row+1
		}
		for (int c = C-1; c >= 1; c--) {
			map[row][c] = map[row][c-1]; // C-1 ~ 1
		}
		map[row][0] = -1;
		map[row][1] = 0;
	}
}
