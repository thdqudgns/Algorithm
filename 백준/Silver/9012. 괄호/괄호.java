import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		final int N = Integer.parseInt(br.readLine());
		String s;
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			sb.append(solve(s)).append('\n');
		}
		System.out.println(sb);
	}
	
	public static String solve(String s) {
		Stack<Character> stack = new Stack<>();
		
		for (int j = 0; j < s.length(); j++) {
		
			char c = s.charAt(j);
			
			if (c == '(') {
				stack.push(c);
			} else if (c == ')' && stack.empty()) {
				return "NO";
			} else {
				stack.pop();
			}
		}
		
		if (stack.empty()) {
			return "YES";
		} else {
			return "NO";
		}
	}
}