import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("data/input2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {	// test_case
			int N = Integer.parseInt(br.readLine());
			int[][] farm = new int[N][N];
			for (int i = 0; i < N; i++) {
				char[] tmp = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					farm[i][j] = tmp[j] - '0';
				}
			}
			
			int r = N / 2;
			int c = N / 2;
			int sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (Math.abs(r - i) + Math.abs(c - j) <= N / 2)
						sum += farm[i][j];
				}
			}
			
			System.out.printf("#%d %d\n", t+1, sum);

		}
	}
}