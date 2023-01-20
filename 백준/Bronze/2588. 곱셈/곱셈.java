import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num1 = br.readLine();
		String num2 = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 3; i++) {
			sb.append(Integer.parseInt(num1) * (num2.charAt(2 - i) - '0')).append('\n');			
		}
		sb.append(Integer.parseInt(num1) * Integer.parseInt(num2));
		
		System.out.print(sb);
	}
}