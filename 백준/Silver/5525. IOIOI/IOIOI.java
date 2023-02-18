import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		int M = Integer.parseInt(sc.nextLine());
		String S = sc.nextLine();
		String sn = "";
		for (int i = 0; i < N; i++) {
			sn += "IO";
		}
		sn += "I";
		int cnt = 0;
		int i = 0;
		while (i < M - (N*2)) {
			if (S.charAt(i) == 'I') {
				String tmp = S.substring(i, i+(2*N+1));
				if (tmp.equals(sn)) {
					cnt++;
					i += 2;
					continue;
				}
			} 
			i += 1;
			
		}
		System.out.println(cnt);
	}
}
