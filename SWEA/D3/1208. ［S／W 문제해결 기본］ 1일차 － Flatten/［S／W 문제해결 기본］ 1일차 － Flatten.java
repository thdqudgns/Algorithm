import java.util.Scanner;

public class Solution {
	static int[] arr;
	static int cnt;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		for(int tc=1;tc<=10;++tc) {
			arr = new int[101];
			cnt = sc.nextInt();
			
			int high = 0, low = 987654321;
			
			for(int i=0;i<100;++i) {
				int input = sc.nextInt();
				arr[input]++;
				high = Math.max(high, input);
				low = Math.min(low, input);
			}
			
			for(int i=0;i<cnt;++i) {
				if(high >= low) {
					arr[high]--;
					arr[high-1]++;
					arr[low]--;
					arr[low+1]++;
					while(arr[high] == 0) high--;
					while(arr[low]==0) low++;
				}
			}
			System.out.println("#" + tc + " " + (high-low));
		}
	}
}