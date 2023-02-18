import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(br.readLine()));
		}
		set.forEach(System.out::println);
	}
}