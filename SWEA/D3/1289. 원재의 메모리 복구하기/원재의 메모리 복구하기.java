import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(sc.nextLine());
		for (int t = 1; t <= T; t++) {
			String s = sc.nextLine();
			int cnt = count(s);
			sb.append("#"+t+" "+cnt+"\n");
		}
		System.out.println(sb);
	}

	private static int count(String s) {
		int cnt = 0;
		char tmp = '0';
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) != tmp) {
				cnt++;
				tmp = tmp == '0' ? '1' : '0';
			}
		}
		return cnt;
	}
}
