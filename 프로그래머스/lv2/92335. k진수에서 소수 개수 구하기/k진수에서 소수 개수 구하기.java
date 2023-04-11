/**
    1. n을 k진수로 바꾼다.
    2. 100만을 2진수로 바꾸어도 2^20승 정도다.
    그럼 20개의 bit가 사용될 수 있다는 건데, 10^20은 1천경이다...
    long으로 하면 되려나?
    
    10진수 -> N진수
    Integer.toString(10진수, N); 을 사용해 변환 가능하다
    대박박박박박
 */
import java.util.*;
import java.math.BigInteger;
class Solution {
	static int cnt = 0;
    public int solution(int n, int k) {
        String[] res = change(n, k).split("0+");
        for (String num : res) {
            prime(num);
        }

        return cnt;
    }
    
    private void prime(String num) {
    	long n = Long.parseLong(num);
        if(n <= 1) return;
        for(long i = 2; i * i <= n; i++) {
            if(n % i == 0) return;
        }
        cnt++;
	}

	public static String change(int n, int k) {
        StringBuilder ans = new StringBuilder();
        while(n != 0) {
            int r = n % k;
            ans.append(r);
            n /= k;
        }
        return ans.reverse().toString();
    }
}