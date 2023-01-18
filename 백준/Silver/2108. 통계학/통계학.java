import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] fre = new int[8001];	//최빈값을 구하기 위해 -4000~4000
		double sum = 0;
//		int max = -2100000000;
//		int min = 2100000000;
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
			fre[arr[i] + 4000] += 1;
//			max = arr[i] > max ? arr[i] : max;
//			min = arr[i] < min ? arr[i] : min;
		}
		
		int freMax = 0;
		int[][] freArr = new int[n][2];
		int idx = 0;
		
		for (int i = 0; i < 8001; i++) {
			if (fre[i] != 0) {
				freArr[idx][0] = fre[i];	// 카운팅 수
				freArr[idx][1] = i - 4000;	// 실제 수
				idx++;
			}
		}
		
		// freArr 출력 점검
//		for (int[] a : freArr) {
//			System.out.println(a[0] + " " + a[1]);
//		}
		
		Arrays.sort(freArr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]!=o2[0] ? o2[0] - o1[0] : o1[1]-o2[1];
			}
			
		});
		
		// freArr 출력 점검
//		for (int[] a : freArr) {
//			System.out.println(a[0] + " " + a[1]);
//		}

		Arrays.sort(arr);
		
		//산술평균
		System.out.println(Math.round(sum / n));
		//중앙값
		System.out.println(arr[n/2]);
		//최빈값
		if (freArr.length > 1 && freArr[0][0] > freArr[1][0]) {
			System.out.println(freArr[0][1]);
		} else if (freArr.length > 1 && freArr[0][0] == freArr[1][0]) {
			System.out.println(freArr[1][1]);
		} else if (freArr.length == 1) {
			System.out.println(freArr[0][1]);
		}
		// 범위
//		System.out.println(max - min);
		System.out.println(arr[n-1] - arr[0]);
		
	}
}
