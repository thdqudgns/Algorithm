import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[2000001];
		int[] input = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[num]++;
			input[i] = num;
		}
		int cnt = 0;
		int x = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			if (x-input[i] > 0) {
				int idx = x-input[i];
				if(arr[idx] > 0) cnt++;
			}
		}
		System.out.println(cnt/2);
	}
}