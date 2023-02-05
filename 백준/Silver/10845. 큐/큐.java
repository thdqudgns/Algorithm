import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Queue<Integer> que = new LinkedList<>();
		// poll() : 헤드 요소를 조회(출력 가능)하고 제거, 하지만 큐가 비어 있다면 null 반환
		// peek() : 헤드 요소 조회 및 반환, 하지만 큐가 비어 있다면 null 반환
		int back = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			if (order.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				back = num;
				que.add(num);
			} else if (order.equals("pop")) {
				if (que.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(que.poll()).append('\n');
				}
			} else if (order.equals("size")) {
				sb.append(que.size()).append('\n');
			} else if (order.equals("empty")) {
				if (que.isEmpty()) {
					sb.append(1).append('\n');
				} else {
					sb.append(0).append('\n');
				}
			} else if (order.equals("front")) {
				if (que.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(que.peek()).append('\n');
				}
			} else if (order.equals("back")) {
				if (que.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(back).append('\n');
				}
			}
		}
		System.out.println(sb);
	}
}