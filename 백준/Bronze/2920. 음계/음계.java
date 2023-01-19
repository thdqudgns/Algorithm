import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] music = new int[8];
		for (int i = 0; i < 8; i++) {
			music[i] = Integer.parseInt(st.nextToken());
		}
		
		String pm;
		if (music[1] - music[0] >= 0) {
			pm = "+";
		} else {
			pm = "-";
		}
		
		// 증가하다가 감소하거나, 감소하다가 증가하면 체크
		boolean chk = true;
		
		for (int i = 2; i < 8; i++) {
			String tmp;
			if (music[i] - music[i-1] >= 0) {
				tmp = "+";
			} else {
				tmp = "-";
			}
			
			if (!tmp.equals(pm)) {
				chk = false;
				break;
			}
		} //for
		
		if (!chk) {
			System.out.println("mixed");
		} else if (pm.equals("+")) {
			System.out.println("ascending");
		} else if (pm.equals("-")) {
			System.out.println("descending");
		}
		
	}//main
}//class