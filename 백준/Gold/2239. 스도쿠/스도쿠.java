import java.util.*;
import java.io.*;

public class Main {
	static final int N = 9;
	static int[][] map;
	static List<int[]> zero;
	static boolean flag = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[N][N];
		zero = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String st = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = st.charAt(j) - '0';
				if (map[i][j] == 0) zero.add(new int[] {i, j});
			}
		}
		//System.out.println(zero);
		solve(0);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	private static void solve(int idx) {
		if (flag) return;
		if (idx == zero.size()) {
//			for (int i = 0; i < N; i++)  
//				for (int j = 0; j < N; j++)
//					if (map[i][j] == 0) return;
			flag = true;
			return;
		}
		int i = zero.get(idx)[0];
		int j = zero.get(idx)[1];
		int num = 0;
		while (++num <= N) {
			if(!check(num, i, j)) {
				continue; 
			}
			map[i][j] = num;
			solve(idx+1);
			if(flag) return;
			map[i][j] = 0;
		}
			
	}
	private static boolean check(int num, int r, int c) {
		for (int i = 0; i < N; i++) {
			if (map[r][i] == num) return false;
			if (map[i][c] == num) return false;
		}
		for (int i = (r/3)*3; i < (r/3)*3 + 3; i++) {
			for (int j = (c/3)*3; j < (c/3)*3 + 3; j++) {
				if (map[i][j] == num) return false;
			}
		}
		return true;
	}
}
