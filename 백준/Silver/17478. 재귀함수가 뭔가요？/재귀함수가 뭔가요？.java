import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다."); 
		System.out.println(recursion(n, 0));
	}

	private static String recursion(int num, int cnt) {
		if (num == 0) 
			return  bar(cnt) + "\"재귀함수가 뭔가요?\"\n" + bar(cnt) + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n" + bar(cnt) + "라고 답변하였지.\n";
		print(cnt);
		return recursion(num-1, cnt+1) + bar(cnt) + "라고 답변하였지.\n";
	}

	private static void print(int cnt) {
		String print = "";
		print += bar(cnt);
		print += "\"재귀함수가 뭔가요?\"\n";
		print += bar(cnt);
		print += "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
		print += bar(cnt);
		print += "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
		print += bar(cnt);
		print += "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
		System.out.print(print);
	}

	private static String bar(int cnt) {
		String out = "";
		for (int i = 0; i < cnt; i++) {
			out += "____";
		}
		return out;
	}
}