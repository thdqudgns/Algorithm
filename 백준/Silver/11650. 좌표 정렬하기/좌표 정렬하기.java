import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		final int N = Integer.parseInt(br.readLine());
		// 이번엔 10814와는 달리, int형의 2차원 배열로 풀어보았다.
		int[][] coordinate = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			coordinate[i][0] = Integer.parseInt(st.nextToken());	// x 
			coordinate[i][1] = Integer.parseInt(st.nextToken());	// y
		}
		
		/*
		 * Arrays.sort(coordinate)	만 한다면,
		 * java.lang.ClassCastException: class [I cannot be cast to class java.lang.Comparable 
		 * ([I and java.lang.Comparable are in module java.base of loader 'bootstrap')
		 * 예외가 발생한다. 2차원 배열의 정렬은 조건을 더해줘야 하기 때문이다.
		 */
		Arrays.sort(coordinate, (c1, c2) -> {
			if (c1[0] == c2[0]) return c1[1] - c2[1];	// x값이 같다면 y로 오름차순 정렬
			else return c1[0] - c2[0];	// x값이 다르다면 당연히 x로 오름차순 정렬
		});
		
		for (int i = 0; i < N; i++) {
			sb.append(coordinate[i][0]).append(" ").append(coordinate[i][1]).append('\n');
		}
		
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
	}
}