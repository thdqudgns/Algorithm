import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] numbers;
	static int[] result;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		result = new int[M];
		numbers = new int[N];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			numbers[i] = i+1;
		}
		
		perm(0, 0);
	}
	
	private static void perm(int cnt, int start) {
		if (cnt == M) {
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i < N; i++) {
			if (visited[i]) continue;
			
			visited[i] = true;
			result[cnt] = numbers[i];
			perm(cnt + 1, i);
			visited[i] = false;
		}
	}
}