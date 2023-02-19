import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[][] map;
	static String res = "";
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String in = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = in.charAt(j) - '0';
			}
		}
		solve(N/2, 0, 0);	// 절반, 시작 row와 col
		res = res.replace("(0000)", "0");
		res = res.replace("(1111)", "1");
		System.out.println(res);
	}
	/*
	 * r: 기준시작점 ~ 절반 // c: 기준시작점 ~ 절반
	 * r: 기준시작점 ~ 절반 // c: 절반 ~ 기준종점
	 * r: 절반 ~ 기준종점 // c: 기준시작점 ~ 절반
	 * r: 절반 ~ 기준종점 // c: 절반 ~ 기준종점
	 */
	private static void solve(int n, int row, int col) {
		int start = map[row][col];
		boolean one = true;
		boolean two = true;
		boolean three = true;
		boolean four = true;
		res += "(";
		ONE:
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[row + i][col + j] != start) {
					solve(n/2, row, col);
					one = false;
					break ONE;
				}
			}
		}
		if (one) res += String.valueOf(start);
		
		TWO:
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[row + i][col + j + n] != start) {
					solve(n/2, row, col + n);
					two = false;
					break TWO;
				}
			}
		}
		if (two) res += String.valueOf(start);
		
		THREE:
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[row + i + n][col + j] != start) {
					solve(n/2, row + n, col);
					three = false;
					break THREE;
				}
			}
		}
		if (three) res += String.valueOf(start);
		
		FOUR:
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[row + i + n][col + j + n] != start) {
					solve(n/2, row + n, col + n);
					four = false;
					break FOUR;
				}
			}
		}
		if (four) res += String.valueOf(start);
		res += ")";
	}
}
