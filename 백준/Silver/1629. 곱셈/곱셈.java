import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 참고 : https://st-lab.tistory.com/237
 * 
 * 이런 수학적인 문제 + DP는 과감하게 PASS
 */

public class Main {
	static long C;
	static long[] dp;	// 값이 없는 상황을 0이 아닌, null로 확인하기 위해서 Wrapper클래스 사용함
	public static void main(String[] args) throws IOException {
		// (A * B) % p = ((A % p) * (B % p)) % p
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		System.out.println(pow(A, B));
		
	}
	private static long pow(Long A, Long exponent) {	// exponent : 멱지수 - 지수의 횟수
		if(exponent == 1) {
			return A % C;	// 마지막에 %C 된것이 반환되기에 밑에서는 또 temp%C 해줄 필요가 없다.
		}
		
		long temp = pow(A, exponent/2);
		
		if (exponent % 2 == 1) {
			return (temp * temp % C) * A % C;
		}
		
		return temp * temp % C;
	}
}
