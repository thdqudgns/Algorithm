import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
// https://st-lab.tistory.com/216
public class Main {
	static int N, M, cnt;
	static LinkedList<Integer> deq = new LinkedList<>();
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		for (int i = 1; i <= N; i++) {
			deq.offer(i);	// deq 채우기
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());	// deq의 위치 입력받기
		}
		// 위치가 주어지지 않은 원소는 빼면 안되고, 이동만 시켜야 한다.
		for (int i = 0; i < M; i++) {
			// 덱에서 뽑고자 하는 숫자의 index 저장
			int targetIdx = deq.indexOf(arr[i]);
			int halfIdx;
			/*
			 * 만약 현재 덱의 원소가 짝수개라면 중간 index를
			 * 현재 덱의 절반 크기에서 -1 감소시킨다.
			 * 
			 * {1,2,3,4} 에서 2를 중간지점으로 하면
			 * index는 1이기 때문.
			 */
			if (deq.size() % 2 == 0) {
				halfIdx = deq.size() / 2 - 1;
			} else {
				halfIdx = deq.size() / 2;
			}
			// 원소의 위치가 중간보다 앞에 있거나, 중간에 있을 때
			if(targetIdx <= halfIdx) {
				// targetIdx보다 앞에 있는 원소들을 모두 뒤로 보낸다.
				for (int j = 0; j < targetIdx; j++) {
					deq.offer(deq.pollFirst());
					cnt++;
				}
			} else { // 중간보다 뒤에 있을 때
				// targetIdx를 포함하여, 뒤에 있는 원소들을 앞으로 보낸다.
				for (int j = 0; j < deq.size() - targetIdx; j++) {
					deq.offerFirst(deq.pollLast());
					cnt++;
				}
			}
			deq.pollFirst();
		}
		System.out.println(cnt);
	}
}