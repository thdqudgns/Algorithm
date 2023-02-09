import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int cha = Integer.MAX_VALUE;
	static int[][] materials;
	static boolean[] selected;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 신맛은 곱이고 쓴맛은 합이다. 이 차이를 줄이는 요리를 만들어라
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		materials = new int[N][2];
		selected = new boolean[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			materials[i][0] = Integer.parseInt(st.nextToken()); // 심
			materials[i][1] = Integer.parseInt(st.nextToken());	// 씀
		}
		recur(0);
		System.out.println(cha);
	}
	private static void recur(int cnt) {
		if (cnt == N) {
			int sim = 1;
			int ssem = 0;
			for (int i = 0; i < N; i++) {
				if (!selected[i]) continue;
				sim *= materials[i][0];
				ssem += materials[i][1];
			}
			// 공집합 제외
			if (ssem == 0) return;	// ssem은 양의 정수인데, 더해지지 않은 경우
			cha = Math.min(cha, Math.abs(sim - ssem));
			return;
		}
			
		// 수행문 - 상태공간 트리를 생각하면 된다.
		selected[cnt] = true;
		recur(cnt + 1);	// 선택했을 때
		selected[cnt] = false;
		recur(cnt + 1);	// 선택하지 않았을 때
	}
}
