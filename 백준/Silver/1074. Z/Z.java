import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int r, c;	// index의 범위를 확인할 수
	static int rs, re, cs, ce;	// index의 범위를 확인할 수
	static int result = 0;	// 정답으로 귀결될 수. 점점 더해진다.
	static int x;		// 더할 수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		x = 1<<(N-1);
		find(0, (1<<N)-1, 0, (1<<N)-1, x, x * x);
		System.out.println(result);
		
	}

	private static void find(int rs, int re, int cs, int ce, int x, int num) {
		if (num == 0) return;
		
		if (rs <= r && r <= re-x && cs <= c && c <= ce-x) {
			result += num*0;
			find(rs, re-x, cs, ce-x, x/2, num/4);
		} else if (rs <= r && r <= re-x && cs+x <= c && c <= ce) {
			result += num*1;
			find(rs, re-x, cs+x, ce, x/2, num/4);
		} else if (rs+x <= r && r <= re && cs <= c && c <= ce-x) {
			result += num*2;
			find(rs+x, re, cs, ce-x, x/2, num/4);
		} else if (rs+x <= r && r <= re && cs+x <= c && c <= ce) {
			result += num*3;
			find(rs+x, re, cs+x, ce, x/2, num/4);
		}
	}
}
