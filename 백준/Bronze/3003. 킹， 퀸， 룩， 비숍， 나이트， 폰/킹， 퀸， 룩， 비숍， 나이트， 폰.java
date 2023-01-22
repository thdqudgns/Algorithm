import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 1 1 2 2 2 8
		int[] piece = {1, 1, 2, 2, 2, 8};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < 6; i++) {
			System.out.print(piece[i] - Integer.parseInt(st.nextToken()) + " ");
		}
	}
}