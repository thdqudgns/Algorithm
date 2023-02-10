import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * PriorityQueue는 우선순위 큐다.
 * PriorityQueue는 기본적으로 값이 작은 것이 우선순위가 높다.
 * 그래서 최솟값을 먼저 꺼낼 때는 조건을 추가할 필요가 없다.
 * 하지만, 최댓값을 꺼낼 때에는 람다식이나 (o1, o2) -> o2 - o1
 * Collections.reverseOrder() 을 생성자에 넣어주어야 한다.
 * @author Hun
 */
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
		//PriorityQueue<>(Collections.reverseOrder()) 로 하는 경우도 있다.
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num != 0) {
				pq.offer(num);
			} else {
				if (pq.isEmpty()) {
					sb.append(0 + "\n");
				} else {
					sb.append(pq.poll() + "\n");
				}
			}
		}
		System.out.println(sb);
	}
}
