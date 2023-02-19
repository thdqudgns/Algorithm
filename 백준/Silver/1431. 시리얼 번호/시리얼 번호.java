import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		String[] arr = new String[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextLine();
		}
		Arrays.sort(arr, (o1, o2) -> {
			if (o1.length() != o2.length()) {
				return o1.length() - o2.length();
			} else {	// 길이가 같을 때
				int sum1 = 0, sum2 = 0;
				for (int i = 0; i < o1.length(); i++) {
					int tmp1 = o1.charAt(i) - '0';
					int tmp2 = o2.charAt(i) - '0';
					if (0 <= tmp1 && tmp1 <=9) sum1 += tmp1;
					if (0 <= tmp2 && tmp2 <=9) sum2 += tmp2;
				}
				if (sum1 != sum2) {
					return sum1 - sum2;
				} else {
					for (int i = 0; i < o1.length(); i++) {
						if ((o1.charAt(i) - '0') != (o2.charAt(i) - '0')) {
							return (o1.charAt(i) - '0') - (o2.charAt(i) - '0');
						}
					}
					return 0;
				}
				
			}
		});
		for(String s : arr) {
			System.out.println(s);
		}
	}
}
