// https://st-lab.tistory.com/279
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[N];
		int[] soreted = new int[N];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			soreted[i] = num;
		}
		
		Arrays.sort(soreted);
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (map.containsKey(soreted[i])) continue;
			map.put(soreted[i], cnt++);
		}
		
		for (int i = 0; i < N; i++) {
			sb.append(map.get(arr[i]) + " ");
		}
		System.out.println(sb);
	}
}
