

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int N = sc.nextInt();
		
		int[] score = new int[N];
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			score[i] = sc.nextInt();
			if (score[i] > max) max = score[i];
		}
//		System.out.println(max);
		
//		for (int i = 0; i < score.length; i++) {
//			System.out.println(score[i]);
//		}
		
		double sum = 0;
		
		for (int i = 0; i < N; i++) {
			sum += (score[i] / (double) max * 100);
//			System.out.println(sum);
		}
		System.out.println(sum/N);
	}
}
