import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			map.put(br.readLine(), 1);
		}
		
		int cnt = 0;
		List<String> name = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			String tmp = br.readLine();
			if (map.getOrDefault(tmp, 0) == 1) {
				cnt++;
				name.add(tmp);
			}
		}
		Collections.sort(name);
		sb.append(cnt).append('\n');
		for(String result : name) {
			sb.append(result).append('\n');
		}
		System.out.println(sb);
	}
}