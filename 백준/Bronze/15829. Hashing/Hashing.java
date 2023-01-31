import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		/*
		 * 항의 번호에 해당하는 만큼 특정한 숫자를 거듭제곱
		 * 곱해준 다음 더하는 것
		 * 
		 * 적당히 큰 수 M으로 나눠주자
		 * 
		 * r 31, M 1234567891
		 */
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String str = sc.nextLine();
		long sum = 0L;
		int r = 1;
		int M = 1234567891;
		for (int i = 0; i < str.length(); i++) {
			sum += (str.charAt(i) - 96) * r;
			r *= 31;
		}
		
		System.out.println(sum % M);
	}
}