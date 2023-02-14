import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String one = st.nextToken();
			String two = st.nextToken();
			int[] first = new int[26];
			int[] second = new int[26];
			for (int i = 0; i < one.length(); i++) {
				first[one.charAt(i) - 'a']++;
			}
			for (int i = 0; i < two.length(); i++) {
				second[two.charAt(i) - 'a']++;
			}
			boolean same = true;
			for (int i = 0; i < 26; i++) {
				if (first[i] != second[i]) {
					same = false;
					break;
				}
			}
			if (same) {
				sb.append("Possible\n");
			} else {
				sb.append("Impossible\n");
			}
		}
		System.out.println(sb);
	}
}
