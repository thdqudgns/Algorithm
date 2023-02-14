import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		int[][] arr = new int[2][6];	// 0:여자, 1:남자	// 0~5: 학년
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			arr[s][g-1]++;
		}
		int cnt = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++) {
				if (arr[i][j] == 0) continue;
				if (arr[i][j] % K == 0) cnt += arr[i][j] / K;
				else cnt += arr[i][j] / K + 1;
			}
		}
		System.out.println(cnt);
	}
}
