# 1216. [S/W 문제해결 기본] 3일차 - 회문2
for _ in range(10):     # 10번 반복.
    i = int(input())    # i번째 임을 의미 1~10 순서로 입력 받는다.
    m = [[*map(str, input())]for _ in range(100)]   # 100x100 짜리 2차원 배열을 입력 받는다.
    z = [*map(list, zip(*m))]   # zip()을 이용해 m을 세로로 읽었을 때의 행렬을 새롭게 만든다.
    a = 1
    for j in range(100):
        t = a+1
        while t-a < 3:
            for k in range(101-t):
                r = m[j][k:k+t]
                c = z[j][k:k+t]
                p = 1
                s = 1
                for q in range(t//2):
                    if r[q] != r[t-1-q]:
                        p = 0
                    if c[q] != c[t-1-q]:
                        s = 0
                if p == 1 or s == 1:
                    a = t
            t += 1
    print(f'#{i} {a}')