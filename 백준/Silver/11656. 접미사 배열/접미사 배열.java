import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int L = s.length();
		String[] arr = new String[L];
		for (int i = 0; i < L; i++) {
			arr[i] = s.substring(i);
		}
		Arrays.sort(arr);
		for(String out : arr) {
			System.out.println(out);
		}
	}
}
