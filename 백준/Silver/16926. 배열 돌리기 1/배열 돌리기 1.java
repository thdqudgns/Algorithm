import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R;
	static int[][] origin;
	static Deque<Integer> dq;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		origin = new int[N+1][M+1];
		
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < M+1; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int min = Math.min(N, M);
		solve2(min/2);
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < M+1; j++) {
				System.out.print(origin[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	private static void solve2(int num) {
		if (num == 0) return;
		dq = new ArrayDeque<>();
		input(num);
		//printQ();
		for (int i = 0; i < R; i++) {
			dq.addFirst(dq.pollLast());
		}
		insert(num);
		//printQ();
		solve2(num-1);
	}
	private static void input(int num) {
		//왼쪽으로
		for (int i = M-num+1; i > num; i--) {
			dq.add(origin[num][i]);
		}
		//아래로
		for (int i = num; i < N-num+1; i++) {
			dq.add(origin[i][num]);
		}
		//오른쪽으로
		for (int i = num; i < M-num+1; i++) {
			dq.add(origin[N-num+1][i]);
		}
		//위로
		for (int i = N-num+1; i > num; i--) {
			dq.add(origin[i][M-num+1]);
		}
	}
	private static void insert(int num) {
		//왼쪽으로
		for (int i = M-num+1; i > num; i--) {
			origin[num][i] = dq.poll();
		}
		//아래로
		for (int i = num; i < N-num+1; i++) {
			origin[i][num] = dq.poll();
		}
		//오른쪽으로
		for (int i = num; i < M-num+1; i++) {
			origin[N-num+1][i] = dq.poll();
		}
		//위로
		for (int i = N-num+1; i > num; i--) {
			origin[i][M-num+1] = dq.poll();
		}
	}
	
//	private static void printQ() {
//		// 출력
//		for (int i : dq) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
//	}
	
}
