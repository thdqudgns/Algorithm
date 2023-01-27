import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Member {
	int age;
	String name;
	int order;
	
	public Member(int age, String name, int order) {
		super();
		this.age = age;
		this.name = name;
		this.order = order;
	}
}

public class Main {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Member> memberList = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			int order = i;
			memberList.add(new Member(age, name, order));
		}
		
		Collections.sort(memberList, new Comparator<Member>() {
			@Override
			public int compare(Member o1, Member o2) {
				if (o1.age != o2.age) {
					return o1.age - o2.age;
				} else {
					return o1.order - o2.order;
				}
			}
		});
		
		for (Member b : memberList) {
			System.out.println(b.age + " " + b.name);
		}
		
	}
}
