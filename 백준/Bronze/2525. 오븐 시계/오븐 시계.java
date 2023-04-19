import java.util.Scanner;

/**
 * 오븐구이가 끝나는 시간을 분 단위로 자동적으로 계산한다. 
 * 훈제오리구이를 시작하는 시각과 오븐구이를 하는 데 필요한 시간이 분단위로 주어졌을 때, 
 * 오븐구이가 끝나는 시각을 계산하는 프로그램을 작성하시오.
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt();
		
		int time = h * 60 + m + v;
		h = time / 60;
		m = time % 60;
		if (h >= 24) h %= 24;
		System.out.println(h + " " + m);
	}
}	