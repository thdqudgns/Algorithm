import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			String pal = sc.nextLine();
			boolean flag = true;
			int check = Integer.parseInt(pal);
			
			if (check == 0) return;
			
			for (int i = 0; i < pal.length()/2; i++) {
				if (pal.charAt(i) != pal.charAt(pal.length()-i-1)) {
					flag = false;
				}
			}
			
			if (flag) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
		
	}//main
}//class
