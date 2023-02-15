//package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, R;
	static int[] input, result;
	static boolean[] selected;
	static LinkedHashSet<String> set = new LinkedHashSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		input = new int[N];
		result = new int[R];
		selected = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		perm(0);
		for (String s : set) {
			System.out.println(s);
		}
		System.out.println(sb);
	}
	private static void perm(int cnt) {
		if (cnt == R) {
			String tmp = "";
			for (int i = 0; i < R; i++) {
				tmp += String.valueOf(result[i]) + " ";
			}
			set.add(tmp);
			return;
		}
		for (int i = 0; i < N; i++) {
			//if (selected[i]) continue;
			
			//selected[i] = true;
			result[cnt] = input[i];
			perm(cnt + 1);
			//selected[i] = false;
		}
	}
}
