import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		boolean flag = true;
		int s = 0, e = str.length()-1;
		while(s < e) {
			if (str.charAt(s) != str.charAt(e)) {
				flag = false;
				break;
			}
			s++;
			e--;
		}
		if(flag) System.out.print(1);
		else System.out.print(0);
	}
}