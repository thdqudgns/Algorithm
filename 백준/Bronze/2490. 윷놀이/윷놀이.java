import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int cnt1 = 0;
		int cnt2 = 0;
		int cnt3 = 0;
		
		for (int i = 0; i < 4; i++) {
			if (Integer.parseInt(st.nextToken()) == 0) cnt1++;
		}
		check(cnt1);
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			if (Integer.parseInt(st.nextToken()) == 0) cnt2++;
		}
		check(cnt2);
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			if (Integer.parseInt(st.nextToken()) == 0) cnt3++;
		}
		check(cnt3);
		System.out.println(sb);
	}
	private static void check(int cnt) {
		switch (cnt) {
		case 1:
			sb.append("A" + "\n");
			break;
		case 2:
			sb.append("B" + "\n");
			break;
		case 3:
			sb.append("C" + "\n");
			break;
		case 4:
			sb.append("D" + "\n");
			break;
		default:
			sb.append("E" + "\n");
			break;
		} 
	}
}
