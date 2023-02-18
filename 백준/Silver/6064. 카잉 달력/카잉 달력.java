// https://mygumi.tistory.com/325

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 0; t < T; t++) {
			int year = 0;
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int cnt = x % (m + 1);
	        int tempY = x;
	 
	        for (int i = 0; i < n; i++) {
	            int ty = tempY % n == 0 ? n : tempY % n;
	            if (ty == y) {
	                break;
	            }
	 
	            tempY = ty + m;
	            cnt += m;
	        }
	        sb.append(cnt > lcm(m, n) ? "-1" : cnt);
	        sb.append("\n");
		}
		System.out.println(sb);
	}
	public static int lcm(int a, int b) {
	    return a * b / gcd(a, b);
	}
	public static int gcd(int a, int b) {
	    while (b != 0) {
	        int r = a % b;
	        a = b;
	        b = r;
	    }
	    return a;
	}
}
