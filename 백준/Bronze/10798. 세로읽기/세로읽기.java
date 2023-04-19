import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		StringBuilder ans = new StringBuilder();
		String[][] map = new String[5][15];
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 5; i++) {
			String s = sc.nextLine();
			for (int j = 0; j < s.length(); j++) {
				map[i][j] = String.valueOf(s.charAt(j));
			}
		}
		
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if (map[j][i] == null) continue;
				ans.append(map[j][i]);
			}
		}
		System.out.print(ans.toString());
	}
}
