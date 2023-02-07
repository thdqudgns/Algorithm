import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] numbers;
	static int[] result;
	static StringBuilder sb;
	//static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		M = sc.nextInt();
		
		result = new int[M];
		numbers = new int[N];
		//visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			numbers[i] = i+1;
		}
		
		perm(0);
		
		System.out.println(sb);
	}
	
	private static void perm(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < result.length; i++) {
				sb.append(result[i] + " ");
			}
			sb.append('\n');
			return;
		}
		
		for (int i = 0; i < N; i++) {
			//if (visited[i]) continue;
			
			//visited[i] = true;
			result[cnt] = numbers[i];
			perm(cnt + 1);
			//visited[i] = false;
		}
	}
}