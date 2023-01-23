import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static boolean checkTriangle(int a, int b, int c) {
		// 피타고라스의 정리를 사용하려면 빗변이 a, b, c 중 무엇인지 알아야 한다.
		if (a > b && a > c) {
			if (pythagoreanTheorem(a, b, c)) return true;
		} else if (b > a && b > c) {
			if (pythagoreanTheorem(b, a, c)) return true;
		} else if (c > a && c > b) {
			if (pythagoreanTheorem(c, a, b)) return true;
		}
		
		return false;
	}
	
	public static boolean pythagoreanTheorem(int x, int y, int z) {
		if (x * x == y * y + z * z) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			final int a = Integer.parseInt(st.nextToken());
			final int b = Integer.parseInt(st.nextToken());
			final int c = Integer.parseInt(st.nextToken());
			
			if (a == 0 && b == 0 && c == 0) return;
			
			if (checkTriangle(a, b, c)) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
		}
		
	}
}