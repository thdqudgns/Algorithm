import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		 * A : 000000 0
		 * B : 001111 15
		 * C : 010011 19
		 * D : 011100 28
		 * E : 100110 38
		 * F : 101001 41
		 * G : 110101 53
		 * H : 111010 58
		 * 
		 * 000100 은 A와 하나만 다르고, 다른 문자들과는 두 자 이상 다르므로  A다.
		 * 단, 모든 문자와 두 자 이상 다르면 모른다.
		 * 모르는 문자가 나오는 문자의 위치를 출력한다. (bit가 아니라, 문자기준)
		 */
		
		String[][] pw = new String[][] {
			{"000000", "A"},
			{"001111", "B"},
			{"010011", "C"},
			{"011100", "D"},
			{"100110", "E"},
			{"101001", "F"},
			{"110101", "G"},
			{"111010", "H"},
		};
		
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		String input = sc.nextLine();
		
		int index = 0;
		String output = "";
		
		for (int i = 0; i < N; i++) {
			// word에 6개씩 문자 저장
			String word = "";
			while(word.length() != 6) {
				word += input.charAt(index++);
			}
			//System.out.println(word);	// 확인
			
			// 문자 확인
			for (int j = 0; j < pw.length; j++) {
				// 1. 6개의 숫자가 모두 일치할 때
				if (pw[j][0].equals(word)) {
					output += pw[j][1];
					continue;
				}
				// 2. 6개 중 하나만 다를 때
				// 문자별로 일치하지 않는 숫자 개수 확인
				int check = 0;
				for (int k = 0; k < 6; k++) {
					if (word.charAt(k) != pw[j][0].charAt(k)) 
						check++;
					if (check > 1) 
						break;
				}
				
				if (check == 1) {
					output += pw[j][1];
					continue;
				}
				// 3. 6개 중 두 개 이상 다를 때 -> 전체 확인 필요
			}
			
			if (output.length() != i + 1) {
				System.out.print(i + 1);
				output = "";
				break;
			}
			
		}
		if (output.length() != 0) {
			System.out.print(output);
		}
	}
	
}