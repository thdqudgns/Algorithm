package algorithm.ch2;

// 2525번: 오븐 시계
import java.util.Scanner;
class Main06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		int oven = sc.nextInt();
		
		int minuteSum = m + oven;
		
		int hour = minuteSum/60;	//나누면 정수로 나옴. 나머지 버려짐
		// ~ <120 -> 1, ~ < 180 -> 2 ==>> 나눈 몫을 시간으로 더한다
		//그러다가 H+Hour이 24를 넘어가면? -> 24로 나눈 나머지를 사용한다
		// (H+Hour)%24
		
		int hourSum = h + hour;
		
		int minute = minuteSum%60;	//나머지
		// 나머지를 분으로 사용한다
		
		// HH MM으로 시와 분이 나오고, Oven에 입력한 시간(분)만큼 추가된다
		// 14 30 +20 -> 14 50
//		if( 0 <= sum && sum < 60 ) System.out.println( (H+0) + " " + (sum-0) );
		// 17 40 +70 -> 18 50
		// 17 40 +80 -> 19 0
//		if( 60 <= sum && sum < 120 ) System.out.println( (H+1) + " " + (sum-60) );
//		if( 120 <= sum && sum < 180 ) System.out.println( (H+2) + " " + (sum-120) );
//		if( 180 <= sum && sum < 240 ) System.out.println( (H+3) + " " + (sum-180) );
		// 23 48 +25 -> 0 13
		
		System.out.println( hourSum%24 + " " + minute );
		
	}
}