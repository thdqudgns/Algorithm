import sys

def palindrome(w, s, e, cnt, flag):
    cnt += 1
    if s >= e:
        return 1, cnt
    elif w[s] == w[e]:
        return palindrome(w, s+1, e-1, cnt, flag)   # return을 꼭 넣어줘야 한다.
    else:
        return 0, cnt

T = int(sys.stdin.readline())

for _ in range(T):
    w = sys.stdin.readline().rstrip()
    cnt = 0
    flag = 1
    flag, cnt = map(int, palindrome(w, 0, len(w)-1, cnt, flag))
    print(flag, cnt)