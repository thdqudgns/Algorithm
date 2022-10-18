from math import factorial

N, M = map(int, input().split())

def countNum(num, args):
    cnt = 0
    while num:
        num //= args
        cnt += num    # 몫의 수만큼 들어있으므로
    return cnt

five = countNum(N, 5) - countNum(M, 5) - countNum(N-M, 5)
two = countNum(N, 2) - countNum(M, 2) - countNum(N-M, 2)

print(min(five,two))

# num = factorial(n)//(factorial(m)*factorial(n-m))
# print(num)
# num = str(num)
# cnt = 0
# for i in range(len(num)-1,-1,-1):
#     if num[i] == '0':
#         cnt += 1
#     else:
#         break
# print(cnt)