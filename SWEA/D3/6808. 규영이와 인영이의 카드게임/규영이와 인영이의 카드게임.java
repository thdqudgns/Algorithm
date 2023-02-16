import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static boolean[] card;
	static int[] gyCard, iyCard, pickIY;
	static boolean[] visit;
	static int win, lose;
	static final int nine = 362880;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			card = new boolean[19];	// 1~18번의 카드를 입력받을 배열
			StringTokenizer st = new StringTokenizer(br.readLine());
			// index = 0을 제외하고, true인 index는 규영이가 가진 카드, false인 index는 인영이가 가진 카드
			for (int i = 0; i < 9; i++) card[Integer.parseInt(st.nextToken())] = true;
			// 규영이카드와 인영이 카드를 int 배열로 생성함 -> 이럴거면 boolean은 왜 했을까.
			gyCard = new int[9];
			iyCard = new int[9];
			int gyIdx = 0;
			int iyIdx = 0;
			for (int i = 1; i < 19; i++) {
				if (card[i]) gyCard[gyIdx++] = i;
				else iyCard[iyIdx++] = i;
			}
			pickIY = new int[9];	// 인영이가 조합할 수 있는 카드를 저장할 배열
			visit = new boolean[9];	// 인영이가 카드를 조합할 때, 순열을 사용하기 위해 사용유뮤를 확인할 배열
			win = 0;	// 규영이가 이긴 횟수
			perm(0);
			sb.append("#" + t + " " + win + " " + (nine - win) + "\n");
		}
		System.out.println(sb);
	}
	private static void perm(int cnt) {
		if (cnt == 9) {
			game(gyCard, pickIY);
			return;
		}
		// 순열을 만들어 pickIY에 저장
		for (int i = 0; i < 9; i++) {
			if (visit[i]) continue;
			visit[i] = true;
			pickIY[cnt] = iyCard[i];
			perm(cnt+1);
			visit[i] = false;
		}
	}
	private static void game(int[] gyCard2, int[] pickIY2) {
		int gysum = 0;
		int iysum = 0;
		for (int i = 0; i < 9; i++) {
			if (gyCard2[i] > pickIY2[i]) {
				gysum += gyCard2[i] + pickIY2[i];	// 규영이가 이기면 점수 가져가고 
			} else {
				iysum += gyCard2[i] + pickIY2[i]; // 인영이가 이기면 점수 가져간다.
			}
		}
		if (gysum > iysum) win++;	// 규영이가 이긴 횟수 늘리기
	}
}
