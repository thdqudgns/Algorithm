/**
    1. n을 k진수로 바꾼다.
    2. 100만을 2진수로 바꾸어도 2^21승 정도다.
    그럼 21개의 bit가 사용될 수 있다는 건데, 10^21은 1만경이다...
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
        //System.out.println(Arrays.toString(res));
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
        String ans = "";
        while(n != 0) {
            int r = n % k;
            ans = String.valueOf(r) + ans;
            n /= k;
        }
        return ans;
    }
}