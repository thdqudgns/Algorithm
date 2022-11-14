# 2005. 파스칼의 삼각형
def factorial(n):
    answer = 1
    for i in range(2, n+1):
        answer *= i
    return answer

def bino_factorial(n, r):   # 0이 들어와도 된다. 0이 들어와도 1이 되기 때문.
    return factorial(n) // factorial(r) // factorial(n-r)

for tc in range(1, int(input())+1):
    n = int(input())
    print(f'#{tc}')
    for i in range(n):
        for j in range(i+1):
            print(bino_factorial(i, j), end=' ')
        print()