import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		if (m >= 45 && m < 60) {
			m -= 45;
			System.out.println(h + " " + m);
		} else {
			m = 60 - (45 - m);
			h -= 1;
			if (h == -1) h = 23;
			System.out.println(h + " " + m);
		}
	}
}