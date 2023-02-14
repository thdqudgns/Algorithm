import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] number = new int[10];
		for (int i = 0; i < s.length(); i++) {
			int num = s.charAt(i) - '0';
			if (num == 9 || num == 6) {
				number[6]++;
				continue;
			}
			number[num]++;
		}
		number[6] = (number[6]+1)/2;
		int max = 0;
		for (int i = 0; i < 9; i++) {
			max = Math.max(max, number[i]);
		}
		System.out.println(max);
	}
}
