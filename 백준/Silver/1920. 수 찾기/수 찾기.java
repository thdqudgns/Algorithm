import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Set<Integer> arr = new TreeSet<>();	// 입력받자마자 정렬
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		
		List<Integer> list = List.copyOf(arr);
		
		int M = Integer.parseInt(br.readLine());
		//int[] find = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			//find[i] = Integer.parseInt(st.nextToken());
			sb.append(binarySearch(list, Integer.parseInt(st.nextToken()))).append('\n');
		}
		
		bw.write(sb.toString());
		bw.close();
		
		
		//list.forEach(System.out::print);
		/*
		for (int i : find) {
			System.out.println(i);
		}
		*/
	}
	
	public static int binarySearch(List<Integer> list, int target) {
		int start = 0;
		int end = list.size() - 1;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			if (list.get(mid) == target) return 1;
			
			if (list.get(mid) > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
        return 0;
		
	}
}