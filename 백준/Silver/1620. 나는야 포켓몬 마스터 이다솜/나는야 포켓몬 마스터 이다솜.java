import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, String> mapNum = new HashMap<>();
		Map<String, String> mapStr = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			String tmp = br.readLine();
			mapNum.put(String.valueOf(i), tmp);
			mapStr.put(tmp, String.valueOf(i));
		}
		/* 입력 확인
		for (int i = 1; i <= N; i++) {
			System.out.println(map.get(i));
		}
		*/
		
		for (int i = 0; i < M; i++) {
			String tmp = br.readLine();
			if (mapNum.containsKey(tmp)) {	//숫자가 들어온 경우
				sb.append(mapNum.get(tmp)).append('\n');
			} else {
				sb.append(mapStr.get(tmp)).append('\n');
			}
		}
		System.out.println(sb);
	}
}
