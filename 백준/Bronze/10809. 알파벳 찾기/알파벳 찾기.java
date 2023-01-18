import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		int[] arr = new int[26];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = -1;
		}
		
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		
		for (int i = 0; i < word.length(); i++) {
			int num = word.charAt(i) - 97;
			if (arr[num] == -1) {
				arr[num] = i;
			}
		}
		
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
}