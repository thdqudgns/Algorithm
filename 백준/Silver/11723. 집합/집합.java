import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static Set<Integer> S;
	 public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		S = new HashSet<>();
		StringTokenizer st  = null;
		for (int t = 0; t < M; t++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			if (order.equals("add")) {
				S.add(Integer.parseInt(st.nextToken()));
			} else if (order.equals("remove")) {
				S.remove(Integer.parseInt(st.nextToken()));
			} else if (order.equals("check")) {
				if(S.contains(Integer.parseInt(st.nextToken()))) sb.append(1 + "\n");
				else sb.append(0 + "\n");
			} else if (order.equals("toggle")) {
				Integer num = Integer.parseInt(st.nextToken());
				if(S.contains(num)) S.remove(num);
				else S.add(num);
			} else if (order.equals("all")) {
				S = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
			} else if (order.equals("empty")) {
				S.clear();;
			} 
		}
		System.out.println(sb);
	}
}
