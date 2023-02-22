import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		Stack<Integer> s = new Stack<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Deque<Integer> deq = new LinkedList<>();
		Deque<Integer> d = new ArrayDeque<>();
		LinkedHashSet<String> set = new LinkedHashSet<>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(((long)N)*4);
	}
}
