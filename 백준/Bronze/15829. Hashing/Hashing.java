import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 항의 번호에 해당하는 만큼 특정한 숫자를 거듭제곱
		 * 곱해준 다음 더하는 것
		 * 
		 * 적당히 큰 수 M으로 나눠주자
		 * 
		 * r 31, M 1234567891
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] r = new long[n];
		r[0] = 1;
		for (int i = 1; i < n; i++) {
			r[i] = r[i - 1] * 31;
		}
		String str = br.readLine();
		long sum = 0L;
		int M = 1234567891;
		for (int i = 0; i < n; i++) {
			sum += (str.charAt(i) - 96) * r[i];
		}
		System.out.println(sum % M);
	}
}