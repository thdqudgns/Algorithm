import java.util.Scanner;

// https://girawhale.tistory.com/3
/**
 * n-3을 밟고 n-1번 계단을 밟고 오는 경우와 n-2번을 밟고 오는 경우 2가지가 존재한다.
 * 
 * 연속해서 3개의 계단을 밟는 것은 불가능하기 때문에 이외의 경우는 존재하지 않는다. 
 * 또한, 조건을 고려하며 한칸을 무조건 뛰는 경우가 발생하므로 연속 3개의 계단을 밟는 경우를 추가적으로 고려하지 않아도 된다.
 * 
 * 각 계단 점수의 배열을 stair, 해당 계단의 위치까지의 최고 점수의 값의 배열을 score라 하였다. 
 * 마지막 칸의 계단은 무조건 밟아야 하므로 위의 경우 2가지 중 큰 값 + 현재 계단의 값을 더한 값이 해당 칸의 score가 된다.
 * 
 * 따라서, score[n] = Math.max(score[n-3] + stair[n-1], score[n-2]) + stair[n]이 성립하게 된다.
 * 유의할 점은 1번과 2번, 3번 계단의 경우는 n-3이 존재하지 않기 때문에 각 경우마다 값을 직접 지정해서 대입해주었다. 
 * (3번 계단의 경우 n-3 = 0이기 때문에 대입하지 않아도 되지만 직관적으로 알기 위해 작성하였다.)
 */
public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] stair = new int[301];
        int[] score = new int[301];
        for (int i = 1; i <= N; i++) {
            stair[i] = sc.nextInt();
        }
        
        score[1] = stair[1];
        score[2] = stair[1] + stair[2];
        score[3] = Math.max(stair[1], stair[2]) + stair[3];

        for (int n = 4; n <= N; n++) {
        	/*
        	 * 현재층의 점수 : 다음 두 점수 중 최댓값 + 현재층의 가중치
        	 * Math.max( (3칸 전까지의 점수합 + 전계단의 가중치), (2칸 전까지의 점수합) );
        	 * + 현재층의 가중치
        	 */
            score[n] = Math.max(score[n-3] + stair[n-1], score[n-2]) + stair[n];
        }

        System.out.println(score[N]);
    }
}
