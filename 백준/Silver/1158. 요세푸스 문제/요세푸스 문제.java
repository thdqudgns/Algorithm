import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) dq.offer(i);
		int cnt = 1;
		while (!dq.isEmpty()) {
			if (cnt == K) {
				sb.append(dq.poll() + ", ");
				cnt = 1;
				continue;
			}
			dq.offer(dq.poll());
			cnt++;
		}
		sb.delete(sb.length()-2, sb.length());
		sb.append(">");
		System.out.print(sb);
	}
}