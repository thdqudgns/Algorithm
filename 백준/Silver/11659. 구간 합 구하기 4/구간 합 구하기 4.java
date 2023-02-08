import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());	// 수의 개수
		int M = Integer.parseInt(st.nextToken());	// 테스트 케이스
		
		int[] numbers = new int[N+1];
		st = new StringTokenizer(br.readLine());
		numbers[0] = 0;
		for (int i = 1; i < N+1; i++) {
			numbers[i] = numbers[i-1] + Integer.parseInt(st.nextToken());
		}
		
		// 테스트케이스
		for (int t = 1; t <= M; t++) {
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;	// 시작점의 전까지 빼야 한다.
			int end = Integer.parseInt(st.nextToken());
			
			sum = numbers[end] - numbers[start];
			
			sb.append(sum).append('\n');
		}
		
		System.out.println(sb);
		
	}
}
