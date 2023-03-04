import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(), t=0;
        while(t++ < T) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.print("Case #" + t + ": ");
            System.out.println(a+b);
        }
    }
}