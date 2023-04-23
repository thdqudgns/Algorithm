//package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		
		/*
		 * (a-d)x + (b-e)y = c-f
		 * (a+d)x + (b+e)y = c+f
		 * y = ((c+f) - (a+d)x) / (b+e)
		 * 
		 * (b+e)(a-d)x - (b-e)*(a+d)x = (c-f)(b+e) - (b-e)*(c+f)
		 * x = (ce-fb) / (ae-bd)
 		 */
		int x = (c*e-f*b) / (a*e-b*d);
		int y = ((c-f) - (a-d)*x)/(b-e);
		System.out.print(x + " " + y);
		
	}
}
