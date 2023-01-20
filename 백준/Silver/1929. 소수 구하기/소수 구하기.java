import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		final int start = Integer.parseInt(st.nextToken());
		final int end = Integer.parseInt(st.nextToken());
		
		boolean[] sosu = new boolean[end+1];
		
		for (int i = 2; i <= end; i++) {
			if (!sosu[i] && i >= start) System.out.println(i);
			for (int j = i; j <= end; j += i) {
				sosu[j] = true;
			}
		}
		
	}
}