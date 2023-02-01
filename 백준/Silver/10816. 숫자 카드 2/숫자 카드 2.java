import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		List<Integer> arr = new ArrayList<>(N);	// 입력받자마자 정렬
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(arr);
		
//		arr.forEach(System.out::print);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			sb.append(higherIndex(arr, num) - lowerIndex(arr, num)).append(" ");
		}
		
		bw.write(sb.toString());
		bw.close();
	}

	private static int higherIndex(List<Integer> list, int target) {
		int start = 0;
		int end = list.size();	// index + 1 도 범위에 포함
		while (start < end) {
			int mid = (start + end) / 2;
			
			if (list.get(mid) > target) {
				end = mid;	// 현재위치가 target보다 커도, 다음 탐색에 포함시켜야 하기 때문에 = mid 이다.
			} else {
				start = mid + 1;
			}
		}
		
		return start;
	}
	
	private static int lowerIndex(List<Integer> list, int target) {
		int start = 0;
		int end = list.size();	// index + 1 도 범위에 포함
		while (start < end) {
			int mid = (start + end) / 2;
			
			if (list.get(mid) >= target) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		
		return start;
	}
}
