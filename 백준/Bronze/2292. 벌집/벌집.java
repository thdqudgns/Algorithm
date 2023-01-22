import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//1 7 19 37 61
		//1+6+12+18+24
		// 1 : 1
		// 2~7 : 2
		// 8~19 : 3
		// 20~37 : 4
		// 38~61 : 5
        
        //sum에는 규칙을 따라 더하고,
        //input값이 sum보다 크면 다음으로 넘기되,
        //넘어온 input값이 sum보다 작거나 같으면 그때의 i값이 지나온 방의 개수가 된다.
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int sum = 1;
        int i = 0;
		while(true) {
			sum += i*6;
			if (input > sum) {
				i++;
                continue;
			} else if (input <= sum) {
				System.out.println(i+1);
				break;
			}
        }
	}
}