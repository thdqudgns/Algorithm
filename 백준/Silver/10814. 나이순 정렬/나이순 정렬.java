import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
		
		br.close(); // 닫아줘야 데이터를 잘 전송한다고 했다.
		
		/*
		 **** 익명클래스를 이용해서 정렬하기 - Comparator를 상속받은 어떤 클래스를 익명화 함 ****
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
		 */
		
		// 2. 람다식을 이용해 간단하게 표현하기
		Collections.sort(memberList, (o1, o2) -> {
				if (o1.age != o2.age) {	return o1.age - o2.age;	} // 나이가 다르면 나이순
				else { return o1.order - o2.order; }	// 나이가 같으면 들어온 순서대로
		});
		
		// 3. forEach와 StringBuilder 사용하기
		/*
		for (Member m : memberList) {
			sb.append(m.age).append(" ").append(m.name).append('\n');
		}
		*/
		// forEach()와 람다식을 사용하며 간단하게 코드 작성함
		memberList.forEach(m -> sb.append(m.age).append(" ").append(m.name).append('\n'));
        
        //4. bw를 사용하면서 시간을 더 줄였다.
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
	}
}