import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[K];
		int max = 0;
		//System.out.println(K + " " + N);
		for (int i = 0; i < K; i++) {
			int tmp = Integer.parseInt(br.readLine());
			//System.out.println(tmp);
			arr[i] = tmp;
			max = tmp > max ? tmp : max;
		}
		
		System.out.println(binarySearch(arr, N, max));
		
	}
	
	public static int binarySearch(int[] list, int n, int end) {
		int start = 0;
		
		while (start < end) {
			int mid = (int) ((start + (long) end + 1) / 2);
			
			/*
			 * mid를 기준으로 잘랐을 때, 랜선의 개수가 n개 이상이라면
			 * start를 mid로 두고, 아니라면 end를 mid - 1로 둔다.
			 */
			
			int line = 0;
			for (int i = 0; i < list.length; i++) {
				line += list[i] / mid;
			}
			//System.out.println("line : " + line);
			if (line >= n) {
				start = mid;
			} else {
				end = mid - 1;
			}
		}
		
		return start;
	}
}