import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		Scanner sc = new Scanner(System.in);
		final int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] > max) max = arr[i];
			if (arr[i] < min) min = arr[i];
		}
		
		System.out.println(min + " " + max);
		
	}
}
