import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K; // 수의 개수, 수의 변경일 일어나는 회수, 구간의 합을 구하는 회수
	static long[] input, tree; // 입력받는 N개의 수 저장, 구간합을 저장하는 배열
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		input = new long[N+1];
		tree = new long[N+1];
		for (int i = 1; i <= N; i++) {
			input[i] = Long.parseLong(br.readLine());
		}
		//System.out.println(Arrays.toString(input));
		for (int i = 1; i <= N; i++) {
			update(i, input[i]);
		}
		int T = M + K;
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			long v1 = Long.parseLong(st.nextToken());
			long v2 = Long.parseLong(st.nextToken());
			//System.out.println(String.format("%d, %d, %d", order, v1, v2));
			if (order == 1) { // v1 -> v2로 바꾸기
				update(v1, v2 - input[(int) v1]);
				input[(int)v1] = v2; // ★★★★★ 
			} else { // v1 ~ v2 사이의 수 구하기
				long result = getRange(v1, v2);
				//System.out.println(result);
				sb.append(result).append("\n");
			}
		}
		System.out.print(sb.toString());
	}

	private static void update(long index, long value) {
		while(index <= N) { //★★★★★  등호로 변경
			tree[(int) index] += value;
			index += (index & -index);
		}
	}

	private static long getRange(long v1, long v2) {
		return sum(v2) - sum(v1-1);
	}

	private static long sum(long index) {
		long result = 0;
		while(index > 0) {
			result += tree[(int) index];
			index -= (index & -index);
		}
		return result;
	}

}
