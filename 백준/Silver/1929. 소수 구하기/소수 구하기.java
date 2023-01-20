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
		
		for (int i = start; i <= end; i++) {
			boolean sosu = true;
			// i가 소수면 출력한다.
			if (i < 2) continue;
			// 1부터 i의 제곱근까지 나눠지는 수가 있으면 소수가 아니다.
			for (int j = 2; j * j <= i; j++) {
				if (i % j == 0) {
					sosu = false;
					break;
				}
			}
			if (sosu) System.out.println(i);
		}
		
	}
}