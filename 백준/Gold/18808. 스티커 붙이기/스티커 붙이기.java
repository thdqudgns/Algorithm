import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K, r, c;
	static int[][] note = new int[42][42];
	static int[][] paper;
	
	static void rotate() {
		int[][] tmp = new int[12][12];
		
		for (int i = 0; i < r; i++) 
			for (int j = 0; j < c; j++) 
				tmp[i][j] = paper[i][j];
		
		for (int i = 0; i < c; i++) 
			for (int j = 0; j < r; j++) 
				paper[i][j] = tmp[r - 1 - j][i];

		int a = r;
		r = c;
		c = a;
	}
	
	static boolean pastable(int x, int y) {
		for (int i = 0; i < r; i++) 
			for (int j = 0; j < c; j++) 
				if (note[x+i][y+j] == 1 && paper[i][j] == 1) 
					return false;
		
		for (int i = 0; i < r; i++) 
			for (int j = 0; j < c; j++) 
				if (paper[i][j] == 1) 
					note[x+i][y+j] = 1;
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		while(K-- > 0) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			paper = new int[12][12];
			for (int i = 0; i < r; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < c; j++) {
					paper[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int rot = 0; rot < 4; rot++) {
				boolean isPaste = false;
				for (int x = 0; x <= N-r; x++) {
					if (isPaste) break;
					for (int y = 0; y <= M-c; y++) {
						if(pastable(x, y)) {
							isPaste = true;
							break;
						}
					}
				}
				if(isPaste) break;
				rotate();
			}
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				cnt += note[i][j];
			}
		}
		System.out.print(cnt);
	}
}
