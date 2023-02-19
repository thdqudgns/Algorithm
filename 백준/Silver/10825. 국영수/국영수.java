//package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Test implements Comparable<Test>{
	
	String name;
	int kor;
	int eng;
	int math;
	
	@Override
	public int compareTo(Test o) {
		if (this.kor != o.kor) return o.kor - this.kor;
		if (this.eng != o.eng) return this.eng - o.eng;
		if (this.math != o.math) return o.math - this.math;
		else return this.name.compareTo(o.name);
	}

	public Test(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
}

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Test> list = new ArrayList<>();
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			list.add(new Test(name, kor, eng, math));
		}
		Collections.sort(list);
		for (Test t : list) {
			sb.append(t.name).append("\n");
		}
		System.out.println(sb);
	}
}
