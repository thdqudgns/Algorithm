import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] A;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int n = Integer.parseInt(st.nextToken());
			int start = 0;
			int end = N - 1;
			boolean exist = false;
			while(start <= end) {
				int mid = start + (end - start) / 2;
				if (A[mid] == n) {
					exist = true;
					break;
				} else if (A[mid] < n) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
			if (exist) sb.append("1\n");
			else sb.append("0\n");
		}
		System.out.println(sb);
	}
}
