import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		// test_case
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			} // 입력 끝
			
			// 5 -> 위) 0, 1, 2 || 아래) 3, 4
			int sum = 0;	// 농작물 수확
			int s = N/2, e = N/2; // 시작점, 종료점
			for (int i = 0; i <= N/2; i++) { // 0 1 2
				for (int j = s; j <= e; j++) {
					sum += map[i][j];
				}
				s--;
				e++;
			}
			
			// 시작점, 종료점은 이제 범위가 줄어들어야 한다.
			s+=2;
			e-=2;
			for (int i = (N/2)+1; i < N; i++) { // 3 4
				for (int j = s; j <= e; j++) {
					sum += map[i][j];
				}
				s++;
				e--;
			}
			sb.append("#"+t+" "+sum+"\n");
		}
		System.out.println(sb);
	}
}
