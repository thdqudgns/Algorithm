import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String in = br.readLine();
		in = in.replace("()", "0");	// 저장을 해야 적용된다.
		char[] c = in.toCharArray();
		Stack<Character> s = new Stack<>();
		int cnt = 0;
		for (int i = 0; i < in.length(); i++) {
			if (c[i] == '(') {
				s.push(c[i]);
				continue;
			} else if (c[i] == ')') {
				s.pop();
				cnt++;
			} else if (c[i] == '0') {
				cnt += s.size();
			}
		}
		System.out.println(cnt);
	}
}
