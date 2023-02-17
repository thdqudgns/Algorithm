import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<>();
		long cnt = 0;
		for (int i = 0; i < N; i++) {
			int in = Integer.parseInt(br.readLine());
			while(!s.isEmpty() && in >= s.peek()) s.pop();
			if (s.isEmpty() || in < s.peek()) {
				cnt += s.size();
				s.push(in);
				continue;
			}
		}
		System.out.println(cnt);
	}
}
