import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, cntm1 = 0, cnt0 = 0, cntp1 = 0;
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
		System.out.println(cntm1);
		System.out.println(cnt0);
		System.out.println(cntp1);
		
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
			int standard = n/3;
			solve(x, y, standard);
			solve(x, y + standard, standard);
			solve(x, y + standard*2, standard);
			solve(x + standard, y, standard);
			solve(x + standard, y + standard, standard);
			solve(x + standard, y + standard*2, standard);
			solve(x + standard*2, y, standard);
			solve(x + standard*2, y + standard, standard);
			solve(x + standard*2, y + standard*2, standard);
		} else {
			if (flag == 0) 
				cnt0++;
			else if (flag == -1) {
				cntm1++;
			} else {
				cntp1++;
			}
		}
	}
}
