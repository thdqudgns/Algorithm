import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(sc.nextLine());
		for (int t = 0; t < T; t++) {
			String s = sc.nextLine();
			sb.append("" + s.charAt(0) + s.charAt(s.length()-1) + "\n");
		}
		System.out.println(sb);
	}
}