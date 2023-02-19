import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, R;
	static char[] input, result;
	static String[] moeum = {"a","e","i","o","u"};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); 
		N = Integer.parseInt(st.nextToken());
		input = new char[N];
		result = new char[R];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(input);
		//System.out.println(Arrays.toString(input));
		comb(0, 0);
	}
	private static void comb(int cnt, int start) {
		if (cnt == R) {
			String res = "";
			for(char c : result) {
				res += String.valueOf(c);
			}
			if (!res.contains("a") && !res.contains("e") && !res.contains("i") && !res.contains("o") && !res.contains("u")) return;
			String tmp = res;
			for (int i = 0; i < 5; i++) {
				tmp = tmp.replace(moeum[i], "");
			}
			if (tmp.length() < 2) return;
			System.out.println(res);
			return;
		}
		for (int i = start; i < N; i++) {
			result[cnt] = input[i];
			comb(cnt + 1, i + 1);
		}
	}
}
