import java.util.Scanner;

public class Main {
	
	static int N, R;
	static int[] inputs;
	static int[] numbers;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = 9;
		R = 7;
		
		inputs = new int[N];
		numbers = new int[R];
		
		for (int i = 0; i < N; i++) {
			inputs[i] = sc.nextInt();
		}
		comb(0, 0);
	}
	
	public static void comb(int cnt, int start) {
		if (cnt == R) {	//종료조건
			int max = 0;
			for (int i = 0; i < R; i++) {
				max += numbers[i];
			}
			if (max == 100) {
				for (int i = 0; i < R; i++) {
					System.out.println(numbers[i]);
				}
			}
			return;
		}
		
		for (int i = start; i < N; i++) {
			numbers[cnt] = inputs[i];
			comb(cnt + 1, i+1);
		}
	}
}