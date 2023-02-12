import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] range = new int[100001];
		Arrays.fill(range, -1);
		range[N] = 0;
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(N);
		while(!q.isEmpty()) {
			if (range[K] != -1) break;
			int n = q.poll();
			for (int i : new int[]{n+1, n-1, n*2}) {
				if (i < 0 || i > 100000) continue;
				if (range[i] != -1) continue;
				range[i] = range[n]+1;
				q.offer(i);
			}
		}
		System.out.println(range[K]);
		
	}
}
