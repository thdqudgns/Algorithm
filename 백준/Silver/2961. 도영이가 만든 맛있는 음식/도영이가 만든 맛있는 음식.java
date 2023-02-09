import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int cha = Integer.MAX_VALUE;
	static int[][] materials;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 신맛은 곱이고 쓴맛은 합이다. 이 차이를 줄이는 요리를 만들어라
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		materials = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			materials[i][0] = Integer.parseInt(st.nextToken()); // 심
			materials[i][1] = Integer.parseInt(st.nextToken());	// 씀
		}
		subset();
		System.out.println(cha);
	}
	private static void subset() {
		for (int i = 1; i < (1<<N); i++) {	// 공집합 제거!!!
			int tmp = 0;	// 차이
			int sim = 1;	// 심
			int ssem = 0;	// 씀
			for (int j = 0; j < N; j++) {
				if ((i & (1<<j)) == 0) continue;
				sim *= materials[j][0];
				ssem += materials[j][1];
			}
			cha = Math.min(cha, Math.abs(sim - ssem));
		}
	}
}
