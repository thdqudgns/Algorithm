import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String number = sc.next();
		
		boolean flag = false;
		
		// i를 1씩 증가시키며 i가 생성자인지 확인한다. 
		for (int i = 1; i <= Integer.parseInt(number); i++ ) {
			int sum = i;
			
			// i의 각 자리를 더해 sum에 누적시킨다.
			for (int j = 0; j < String.valueOf(i).length(); j++) {
				sum += String.valueOf(i).charAt(j)-'0';
			}
			
			/* i가 한자리여도 i자체를 더한다. 그래서 sum = i로 설정했다.
			 * 
			// i가 두자리수 이상이라면, i의 값 자체도 누적시킨다.
			if (String.valueOf(i).length() > 1) {
				sum += i;
			}
			 */
			
			// 테스트
			//System.out.println("i : " + i + ", sum : " + sum);
			
			// 누적된 수가 입력받은 number와 같다면, i는 생성자다.
			if (sum == Integer.parseInt(number)) {
				System.out.println(i);
				flag = true;
				break;
			}
		}
		
		// 아니라면 0을 출력한다.
		if (!flag) {
			System.out.println(0);
		}
		
	}
}