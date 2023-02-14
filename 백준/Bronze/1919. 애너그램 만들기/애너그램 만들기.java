import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String one = br.readLine();
		String two = br.readLine();
		int[] first = new int[26];
		int[] second = new int[26];
		for (int i = 0; i < one.length(); i++) {
			first[one.charAt(i) - 'a']++;
		}
		for (int i = 0; i < two.length(); i++) {
			second[two.charAt(i) - 'a']++;
		}
		int cnt = 0;
		for (int i = 0; i < 26; i++) {
			cnt += Math.abs(first[i] - second[i]);
		}
		System.out.println(cnt);
	}
}
