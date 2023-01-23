import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static boolean checkTriangle(int a, int b, int c) {
		// 피타고라스의 정리를 사용하려면 빗변이 a, b, c 중 무엇인지 알아야 한다.
		if (a > b && a > c) {
			if (a * a == b * b + c * c) return true;
		} else if (b > a && b > c) {
			if (b * b == a * a + c * c) return true;
		} else if (c > a && c > b) {
			if (c * c == a * a + b * b) return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			final int x = Integer.parseInt(st.nextToken());
			final int y = Integer.parseInt(st.nextToken());
			final int z = Integer.parseInt(st.nextToken());
			
			if (x == 0 && y == 0 && z == 0) return;
			
			if (checkTriangle(x, y, z)) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
		}
		
	}
}