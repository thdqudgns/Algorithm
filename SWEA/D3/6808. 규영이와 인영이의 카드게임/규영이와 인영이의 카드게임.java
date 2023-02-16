import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static boolean[] card;
	static int[] gyCard, iyCard, pickIY;
	static boolean[] visit;
	static int win, lose;
	static int nine = 362880;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			card = new boolean[19];
			StringTokenizer st = new StringTokenizer(br.readLine());
			// index = 0을 제외하고, true는 규영이가 가진 카드, false는 인영이가 가진 카드
			for (int i = 0; i < 9; i++) card[Integer.parseInt(st.nextToken())] = true;
			gyCard = new int[9];
			iyCard = new int[9];
			pickIY = new int[9];
			visit = new boolean[9];
			int gyIdx = 0;
			int iyIdx = 0;
			for (int i = 1; i < 19; i++) {
				if (card[i]) gyCard[gyIdx++] = i;
				else iyCard[iyIdx++] = i;
			}
			//System.out.println(Arrays.toString(gyCard));
			//System.out.println(Arrays.toString(iyCard));
			win = 0;
			solve();
			sb.append("#" + t + " " + win + " " + (nine - win) + "\n");
		}
		System.out.println(sb);
	}
	private static void solve() {
		perm(0);
	}
	private static void perm(int cnt) {
		if (cnt == 9) {
			int gysum = 0;
			int iysum = 0;
			for (int i = 0; i < 9; i++) {
				if (gyCard[i] > pickIY[i]) {
					gysum += gyCard[i] + pickIY[i]; 
				} else {
					iysum += gyCard[i] + pickIY[i]; 
				}
			}
			if (gysum > iysum) win++;
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (visit[i]) continue;
			visit[i] = true;
			pickIY[cnt] = iyCard[i];
			perm(cnt+1);
			visit[i] = false;
		}
	}
}
