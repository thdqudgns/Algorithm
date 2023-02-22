import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 97) {
				sb.append((char)(s.charAt(i) - 32));
			} else {
				sb.append((char)(s.charAt(i) + 32));
			}
		}
		System.out.println(sb);
	}
}
