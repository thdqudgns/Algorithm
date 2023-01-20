import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static final int MAX = 1001;
	
	public static ArrayList<Integer> findSosu(boolean[] arr) {
		arr[0] = true;
		arr[1] = true;
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 2; i * i < MAX; i++) {
			if (!arr[i]) {
				for (int j = i; j < MAX; j += i) {
					if (j != i) {
						arr[j] = true;						
					}
				}
			}
		}
		for (int i = 0; i < MAX; i++) {
			if (!arr[i]) {
				result.add(i);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		
		boolean[] sosu = new boolean[MAX];
		/*
		 *  수를 저장하면 오히려 시간이 더 걸리니까
		 *  false으로 저장된 지금, index를 수로 보고
		 *  소수가 아닌 것들은 true로 바꾸자.
		 *  (false가 소수다.)
		 *  이렇게 하면 0으로 남아있는 index들은 소수가 된다.
		 */
		ArrayList<Integer> result = findSosu(sosu);
		
		/*
		for (int r : result) {
			System.out.println(r);
		}
		*/
		
		Scanner sc = new Scanner(System.in);
		final int N = sc.nextInt();
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			int k = sc.nextInt();
			if (result.contains(k)) cnt++;
		}
		
		System.out.println(cnt);
		
		
	}
}
