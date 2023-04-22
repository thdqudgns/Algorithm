import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		for (int i = 1; i < arr.length; i++) arr[i] = i;
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int begin = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int mid = Integer.parseInt(st.nextToken());
			// mid, mid+1, ..., end-1, end, begin, begin+1, ..., mid-1로
			// mid 뒷부분을 앞으로 가져온다
			
			int[] front= Arrays.copyOfRange(arr, begin, mid);
			//System.out.print(Arrays.toString(front) + " | ");
			int[] back = Arrays.copyOfRange(arr, mid, end+1);
			//System.out.println(Arrays.toString(back));
			
			int f = 0, b = 0;
			for (int i = begin; i <= end; i++) {
				if (i < begin + back.length) {
					arr[i] = back[b++];
				} else {
					arr[i] = front[f++];
				}
			}
		}
		for (int i = 1; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
