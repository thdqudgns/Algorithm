import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; //st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			// 초기 암호의 개수
			int N = Integer.parseInt(br.readLine());
			List<String> list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list.add(st.nextToken());	// 암호 저장
			}
			
			// 명령어의 개수
			int O = Integer.parseInt(br.readLine());
			// 명령어 입력
			st = new StringTokenizer(br.readLine());
			while(O > 0) {
				String I = st.nextToken();
				if (I.equals("I")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					while (y > 0) {
						String tmp = st.nextToken();
						list.add(x, tmp);
						x++;
						y--;
					}
				}
				O--;
			}
			sb.append(String.format("#%d ", t));
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i) + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
