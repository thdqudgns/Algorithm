import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 입력받자마자 나머지를 저장한다.
		int[] input = new int[10];
		// 각 index는 수를 의미하며, 나머지를 index로 보고 1씩 증가 -> 0이 아닌 것들의 개수를 세면 된다.
		int[] remainder = new int[42];
		
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			input[i] = sc.nextInt() % 42;
			remainder[input[i]]++;
		}
		
		int cnt = 0;
		for (int i = 0; i < remainder.length; i++) {
			if (remainder[i] != 0) cnt++;
		}
		
		System.out.println(cnt);
		
	}
}