import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		final int start = Integer.parseInt(st.nextToken());
		final int end = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		// 들어온 수의 마지막 범위까지만 배열 생성
		// index는 각 수를 의미한다.
		// 2이상의 수 중, false면 소수고 true면 소수 아님
		boolean[] sosu = new boolean[end+1];
		
		for (int i = 2; i <= end; i++) {
			if (!sosu[i] && i >= start) sb.append(i).append('\n');
			for (int j = i; j <= end; j += i) {
				sosu[j] = true;
			}
		}
		
		System.out.print(sb);
		
	}
}