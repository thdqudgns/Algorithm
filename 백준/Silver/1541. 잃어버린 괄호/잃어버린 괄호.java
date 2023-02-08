import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		//빼기를 기준으로 자르면, 빼기만 하면 된다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split("-");
		int[] results = new int[inputs.length];
		for (int i = 0; i < inputs.length; i++) {
			if (inputs[i].contains("+")) {
				results[i] = change(inputs[i]);
			} else {
				results[i] = Integer.parseInt(inputs[i]);
			}
		}
		int result = results[0];
		if (results.length > 1) {
			for (int i = 1; i < results.length; i++) {
				result -= results[i];
			}
		}
		System.out.println(result);
	}

	private static int change(String input) {
		String[] tmp = input.split("\\+");
		int sum = 0;
		for (String str : tmp) {
			sum += Integer.parseInt(str);
		}
		return sum;
	}
}
