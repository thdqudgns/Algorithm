import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			Stack<Character> s = new Stack<>();
			char[] in = sc.nextLine().toCharArray();
			for (int j = 0; j < in.length; j++) {
				if (s.isEmpty()) {
					s.push(in[j]);
					continue;
				}
				if (s.peek() == in[j]) {
					s.pop();
					continue;
				} else {
					s.push(in[j]);
					continue;
				}
			}
			if (!s.isEmpty()) continue;
			cnt++;
		}
		System.out.println(cnt);
	}
}
