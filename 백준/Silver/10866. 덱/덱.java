import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static Deque<Integer> deq = new LinkedList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			solve(st);
		}
		System.out.println(sb);
	}
	
	private static void solve(StringTokenizer st) {
		String order = st.nextToken();
		if (order.equals("push_front")) {
			int num = Integer.parseInt(st.nextToken());
			deq.addFirst(num);
		} else if (order.equals("push_back")) {
			int num = Integer.parseInt(st.nextToken());
			deq.addLast(num);
		} else if (order.equals("pop_front")) {
			if (deq.isEmpty()) {
				sb.append(-1).append('\n');
			} else {
				sb.append(deq.pollFirst()).append('\n');
			}
		} else if (order.equals("pop_back")) {
			if (deq.isEmpty()) {
				sb.append(-1).append('\n');
			} else {
				sb.append(deq.pollLast()).append('\n');
			}
		} else if (order.equals("size")) {
			sb.append(deq.size()).append('\n');
		} else if (order.equals("empty")) {
			if (deq.isEmpty()) {
				sb.append(1).append('\n');
			} else {
				sb.append(0).append('\n');
			}
		} else if (order.equals("front")) {
			if (deq.isEmpty()) {
				sb.append(-1).append('\n');
			} else {
				sb.append(deq.peekFirst()).append('\n');
			}
		} else if (order.equals("back")) {
			if (deq.isEmpty()) {
				sb.append(-1).append('\n');
			} else {
				sb.append(deq.peekLast()).append('\n');
			}
		}
	}
	
}