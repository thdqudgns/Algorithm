import java.io.*;
import java.util.*;
/**
 * 펜윅 트리 + Lazy propagation
 * 이해는 안되지만 블로그를 보고 어찌저찌...
 * 기존의 tree에 저장했던 값들을 constTree에 저장하고,
 * degreeTree를 추가로 사용하여 풀이함
 *
 * 기존의 tree로 degreeTree가 아니라, constTree를 사용한 이유는 그래야 답이 맞았다.
 * 
 * 기존의 메소드들의 매개변수에 어떤 tree를 사용할 것인지 지정해주었다.
 * @author Hun
 *
 */
public class Main {
	static int N, M, K; // 수의 개수, 수의 변경일 일어나는 회수, 구간의 합을 구하는 회수
	static long[] input; // 입력받는 N개의 수 저장, 구간합을 저장하는 배열
	static long[] degreeTree, constTree; // 일차항 저장, 상수항 저장
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		input = new long[N+1];
		degreeTree = new long[N+1];
		constTree = new long[N+1];
		for (int i = 1; i <= N; i++) {
			input[i] = Long.parseLong(br.readLine());
		}
		
		for (int i = 1; i <= N; i++) { //★★★★★
			update(constTree, i, input[i]); // 상수 저장
		}
		int T = M + K;
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			
			if (order == 1) { // start ~ end에 value 더하기
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				long value = Long.parseLong(st.nextToken());
				rangeUpdate(start, end, value); //★★★★★
			} else { // v1 ~ v2 사이의 수 구하기
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				long result = rangeSum(start, end); //★★★★★
				
				sb.append(result).append("\n");
			}
		}
		System.out.print(sb.toString());
	}
	
	static void rangeUpdate(int start, int end, long x) { //★★★★★
		update(degreeTree, start, x);
		update(degreeTree, end+1, -x);
		
		update(constTree, start, (-start + 1)*x);
		update(constTree, end+1, end*x);
	}

	static long rangeSum(int start, int end) { //★★★★★
		long result = sum(degreeTree, end) * end + sum(constTree, end); // 1 ~ end의 구간합
		return result -= sum(degreeTree, start-1) * (start-1) + sum(constTree, start-1); // 1 ~ start-1의 구간합
	}

	static long sum(long[] tree, int index) {
		long result = 0;
		while(index > 0) {
			result += tree[index];
			index -= (index & -index);
		}
		return result;
	}

	static void update(long[] tree, int index, long value) {
		while(index <= N) { //★★★★★  등호로 변경
			tree[index] += value;
			index += (index & -index);
		}
	}
}
