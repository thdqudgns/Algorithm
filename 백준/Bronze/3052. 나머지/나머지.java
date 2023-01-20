import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 각 index는 수를 의미하며, 값은 나머지로 나온 횟수를 의미한다 1씩 증가 
        // -> 0이 아닌 것들의 개수를 세면 중복을 피해 셀 수 있다.
		int[] remainder = new int[42];
		int cnt = 0;
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++) remainder[sc.nextInt() % 42]++;    // 입력받자마자 나머지를 저장한다.
		for (int i = 0; i < remainder.length; i++) if (remainder[i] != 0) cnt++;
		System.out.println(cnt);
		
	}
}