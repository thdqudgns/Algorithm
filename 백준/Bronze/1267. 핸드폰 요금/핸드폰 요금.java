import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(st.nextToken()); 
		/*
		 * 영식 요금제 : 30초 미만 당 10원
		 * 민식 요금제 : 60초 미만 당 15원
		 */
		int Y = N, M = N;
		for (int i = 0; i < arr.length; i++) {
			Y += arr[i] / 30;
			M += arr[i] / 60;
		}
		double resultY = (double) Y * 10;
		double resultM = (double) M * 15;
		if (resultY < resultM) {
			System.out.print("Y " + (int)resultY);
		} else if (resultM < resultY) {
			System.out.print("M " + (int)resultM);
		} else {
			System.out.println("Y M " + (int)resultM);
		}
	}
}
