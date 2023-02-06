import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			Deque<List<Integer>> print = new LinkedList<>(); // 들어온 수(중요도), index 저장
			List<Integer> important = new ArrayList<>(); // 중요도만 저장
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				List<Integer> list = new ArrayList<>();
				int num = Integer.parseInt(st.nextToken());
				list.add(num);
				list.add(i);
				print.add(list);
				important.add(num);
			}
			
			// 중요도 내림차순 정렬 -> 앞에서부터 중요도 확인하면서 빼낸다. = 0으로만 빼내면 된다.
			Collections.sort(important, Comparator.reverseOrder());
			int cnt = 0;	// 출력된 문서 개수
			List<Integer> check;
			while(important.size() != 0) {	// 문서가 다 빠질 때까지
				if (important.get(0) == print.peekFirst().get(0)) {	// 중요도가 일치한다면 둘 다 제거하면서 cnt++
					important.remove(0);
					check = print.pollFirst();
					cnt++;
					if (check.get(1) == M) break;	// index 확인
				} else {
					print.add(print.pollFirst());	// 중요도가 일치하지 않는다면, 맨 뒤로 보낸다.
				}
			}
			sb.append(cnt).append('\n');
		}
		
		System.out.println(sb);
	}
}