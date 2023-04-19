import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N+1];
		for (int i = 0; i < arr.length; i++) arr[i] = i;
		while(M-- > 0) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N+1; i++) {
			sb.append(arr[i] + " ");
		}
		System.out.print(sb);
	}
}