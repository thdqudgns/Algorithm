import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] res = new int[N];
		Stack<int[]> s = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(st.nextToken());
			// 스택이 비어있으면 input값을 넣는다.
			if (s.isEmpty()) {
				s.push(new int[]{input, i});
				continue;
			}
			if (input <= s.peek()[0]) {
				s.push(new int[] {input, i});
				continue;
			}
			
			// 방금 들어온 값이 stack s 꼭대기에 있는 수보다 크다면
			// 자기보다 작은 수를 빼면서, 개수를 세어주고, 그만큼 자기를 출력한다.
			if (input > s.peek()[0]) {
				while (!s.isEmpty() && input > s.peek()[0]) {
					res[s.pop()[1]] = input;
				}
				s.push(new int[]{input, i});
			}
		}
		s.pop();		// 마지막에 들어간 원소 제거
		res[N-1] = -1;// 마지막에 들어갔으므로 -1 추가
		// 근데도 스택이 비어있지 않다면, 이 값들은 자신보다 큰 수가 없었다는 뜻이다.
		// 그러므로 맨 앞에 -1을 넣어준다.
		int size = s.size();
		int[] tmp = new int[size]; 
		for (int i = size-1; i >= 0; i--) {
			tmp[i] = s.pop()[1];
		}
		for (int i = 0; i < size; i++) {
			res[tmp[i]] = -1;
		}
		for(int i : res) {
			sb.append(i + " ");
		}
		System.out.println(sb);
	}
}
