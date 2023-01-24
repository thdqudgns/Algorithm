import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] big = new int[N][2];
		for (int i = 0; i < big.length; i++) {
			big[i][0] = sc.nextInt();	// 무게
			big[i][1] = sc.nextInt();	// 키
		}
		
		for (int i = 0; i < big.length; i++) {
			int cnt = 0;
			for (int j = 0; j < big.length; j++) {
				if (big[j][0] > big[i][0] && big[j][1] > big[i][1]) 
					cnt++;
			}
			System.out.print(cnt + 1 + " ");
		}
	}
}