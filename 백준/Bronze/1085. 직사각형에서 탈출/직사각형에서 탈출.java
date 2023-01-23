import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int x = Integer.parseInt(st.nextToken());
		final int y = Integer.parseInt(st.nextToken());
		final int w = Integer.parseInt(st.nextToken());
		final int h = Integer.parseInt(st.nextToken());
		
		int minX = x < w - x ? x : w - x;
		int minY = y < h - y ? y : h - y;
		
		System.out.println(Math.min(minX, minY));
		
	}
}