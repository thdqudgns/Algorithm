import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N, R;
	static int[] inputs, numbers;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		inputs = new int[N];
		numbers = new int[R];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			inputs[i] = sc.nextInt();
		}
		
		Arrays.sort(inputs);
		
		perm(0);
		
		System.out.println(sb);
	}
	
	public static void perm(int cnt) {
		if (cnt == R) {	//종료조건
			for (int i = 0; i < R; i++) {
				sb.append(numbers[i] + " ");
			}
			sb.append('\n');
			return;
		}
		
		for (int i = 0; i < N; i++) {
			//if (visited[i]) continue;
			
			//visited[i] = true;
			numbers[cnt] = inputs[i];
			perm(cnt + 1);
			//visited[i] = false;
		}
	}
}
