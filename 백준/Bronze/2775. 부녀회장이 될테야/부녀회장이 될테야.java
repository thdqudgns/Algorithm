//a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다
//비어있는 집은 없고 주어지는 양의 정수 k와 n에 대해 k층에 n호에는 몇 명이 살고 있는지 출력하라.
//아파트에는 0층부터 있고 각층에는 1호부터 있으며, 0층의 i호에는 i명이 산다.
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(sc.nextLine());
            int n = Integer.parseInt(sc.nextLine());
            int[][] a = new int[k + 1][n + 1];
            for (int x = 0; x < k + 1; x++) {
                for (int y = 1; y < n + 1; y++) {
                    if (x == 0){
                        a[x][y] = y;    
                    } else {
                        a[x][y] = a[x][y-1] + a[x-1][y];
                    }
                }
            }
            System.out.println(a[k][n]);
        }
    }
}