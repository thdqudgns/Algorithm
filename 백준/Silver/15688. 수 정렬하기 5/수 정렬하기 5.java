import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[2000000+2];
		for (int i=0; i<N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			nums[1000000+tmp]++;
		}
		
		for (int i=0; i<=nums.length-1; i++) {
			while (nums[i]-- > 0) sb.append(-1000000+i).append("\n");
		}
		System.out.println(sb);
	}
}