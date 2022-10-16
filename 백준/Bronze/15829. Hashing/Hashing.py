import sys
L = int(sys.stdin.readline())
arr = sys.stdin.readline().rstrip()
# L: 문자열의 길이 / 31: 항의 번호만큼 거듭제곱할 수
# 풀이과정: 0항*pow(31, 0) + 1항*pow(31, 1) .... 더하고, 1234567891로 나눈 정수인 나머지를 구함. -> round말고 ''로
sum = 0
M = 1234567891
for i in range(L):
    sum += (ord(arr[i])-96)*pow(31, i)

print(sum%M)