import java.util.Arrays;
import java.util.Scanner;
// 누적합
public class Main {
	public static void main(String[] args) {
		int[] arr = new int[1001];
		int num = 1;
		int index = 1;
		int cnt = 0;
		while (index <= 1000) {
			arr[index] = num + arr[index-1];
			index++;
			cnt++;
			if (cnt == num) {
				num++;
				cnt = 0;
			}
		}
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		System.out.println(arr[B] - arr[A-1]);
	}
}
