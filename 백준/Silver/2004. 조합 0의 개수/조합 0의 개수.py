n, m = map(int, input().split())

# 0의 개수를 구하는 것은 10의 개수를 구하는 것이고,
# 10의 개수는 2*5의 개수인데, 팩토리얼에서는 2가 5보다 항상 많으므로
# 5의 개수만 세어주면 된다.
# 팩토리얼의 5의 개수: num을 5로 나눈 몫을 더하면서 계속 나눔
def countNum(num, power):
    cnt = 0
    while num:
        num = num // power  # 5가 다른 수로 바뀌면, 그 수의 개수를 센다.
        cnt += num
    return cnt

# nCm = n! // m! * (n-m)!
# 5^a // 5^b * 5^c 에서 5의 개수는 5^(a-b-c)

five = countNum(n,5) - countNum(m,5) - countNum(n-m,5)
two = countNum(n,2) - countNum(m,2) - countNum(n-m,2)
print(min(five,two))