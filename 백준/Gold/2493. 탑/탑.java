import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Stack<int[]> topStack = new Stack<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int[] tmp = new int[] {Integer.parseInt(st.nextToken()), i+1};
			// 스택이 비어있다면, 0을 출력하고, 나를 담는다.
			if (topStack.isEmpty()) {
				topStack.push(tmp);
				sb.append(0 + " ");
				continue;
			}
			// 나보다 큰 수가 나올 때까지 스택을 찾는다. 나보다 큰 수가 보인다면, 나를 넣는다.
			// 스택에 나보다 큰 값이 있다면, 그 값의 위치를 출력한다.
			while(!topStack.isEmpty() && topStack.peek()[0] < tmp[0]) {
				topStack.pop();
			}
			// 스택이 비어있다면, 0을 출력하고, 나를 담는다.
			if (topStack.isEmpty()) {
				topStack.push(tmp);
				sb.append(0 + " ");
				continue;
			} else {
				sb.append(topStack.peek()[1] + " ");
				topStack.push(tmp);
			}
		}
		System.out.println(sb);
	}
}
