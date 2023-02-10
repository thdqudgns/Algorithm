import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * PriorityQueue는 우선순위 큐다.
 * PriorityQueue는 기본적으로 값이 작은 것이 우선순위가 높다.
 * 그래서 최솟값을 먼저 꺼낼 때는 조건을 추가할 필요가 없다. 
 * 
 * 하지만, 최댓값을 꺼낼 때에는 람다식이나 (o1, o2) -> o2 - o1
 * Collections.reverseOrder() 을 생성자에 넣어주어야 한다.
 * 
 * 또 새로운 조건을 달려면, Comparator를 익명클래스나 람다식으로 구현해야 한다.
 * @author Hun
 */
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(
				(a,b) -> {
	                if(Math.abs(a) == Math.abs(b)){
	                	// 절댓값이 같다면 a가 클 때 1을 반환, b가 더 크다면 음수 반환
	                    return a > b ? 1 : -1;	
	                } else { // 절댓값이 다를 때에도, a가 크다면 양수가, b가 크다면 음수가 반환될 것이다.
	                	return Math.abs(a) - Math.abs(b);
	                }
            });
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num != 0) {
				pq.offer(num);	// 넣기
			} else {
				if (pq.isEmpty()) {	// 비어있는지 확인
					sb.append(0 + "\n");
				} else {
					sb.append(pq.poll() + "\n"); // 빼기
				}
			}
		}
		System.out.println(sb);
	}
}
