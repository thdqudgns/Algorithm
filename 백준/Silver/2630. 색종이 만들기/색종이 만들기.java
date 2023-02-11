import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, cntBlue = 0, cntWhite = 0;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		solve(0, 0, N);
		System.out.println(cntWhite);
		System.out.println(cntBlue);
		
	}
	private static void solve(int x, int y, int n) {
		int flag = map[x][y];
		boolean divide = false;
		Search:
		for (int i = x; i < x+n; i++) {
			for (int j = y; j < y+n; j++) {
				if (map[i][j] == flag) {
					continue;
				}
				else {
					divide = true;
					break Search;
				}
			}
		}
		
		if(divide) {
			solve(x, y, n/2);
			solve(x, y + n/2, n/2);
			solve(x + n/2, y, n/2);
			solve(x + n/2, y + n/2, n/2);
		} else {
			if (flag == 0) cntWhite++;
			else cntBlue++;
		}
	}
}
