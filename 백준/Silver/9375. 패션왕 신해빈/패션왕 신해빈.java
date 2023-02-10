import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {
	static int N;
	
	/**
	 * 1. 옷의 종류별 개수를 구함
	 * 2. 종류별로 안 입는 경우까지 +1 함
	 * 3. 조합의 개수를 구함
	 * 4. 아무것도 안입는 경우는 제외하기 위해 -1
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			int result = 0;
			Map<String, Integer> map = new HashMap<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String trash = st.nextToken();
				String clothes = st.nextToken();
				// 안 입는 경우까지 미리 고려해주기 위해 초깃값을 1로 설정함
				map.put(clothes, map.getOrDefault(clothes, 1)+1);
			}
			// 조합의 수를 구하는 것은, 이미 옷의 종류를 구분하였으므로 옷의 종류가 중복되는 일은 없다.
			// 곱하기만 하면 된다.
			int value = 1;
			for (int v : map.values()) {
				value *= v;
			}
			result = value - 1;
			sb.append(result + "\n");
		}
		System.out.println(sb);
	}
}
