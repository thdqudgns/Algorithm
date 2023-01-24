import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();	// limit
		sc.nextLine();
		int[] card = new int[N];
		for (int i = 0; i < N; i++) {
			card[i] = sc.nextInt();
		}
		
		// 합하고, 최댓값보다 큰데, M보다 작다면 교환 
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < card.length-2; i++) {
			for (int j = i+1; j < card.length-1; j++) {
				for (int k = j+1; k < card.length; k++) {
					int sum = card[i] + card[j] + card[k];
					if (sum > max && sum <= M) {
						max = sum;
					}
				}
			}
		}
		System.out.println(max);
	}
}