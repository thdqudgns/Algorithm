import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N+1];
		while(M-- > 0) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int k = sc.nextInt();
			for(int idx = i; idx <= j; idx++) {
				arr[idx] = k;
			}
		}
		for (int i = 1; i < N+1; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
