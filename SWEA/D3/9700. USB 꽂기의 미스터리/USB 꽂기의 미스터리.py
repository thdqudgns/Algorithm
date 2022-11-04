T = int(input())
for i in range(1, T+1):
    p, q = map(float, input().split())
    s1 = (1-p)*q    # 1번 뒤집었을 때 꽂힐 확률
    s2 = p*(1-q)*q  # 1번, 또 1번 뒤집었을 때 꽂힐 확률
    flag = 'NO'
    if s1 < s2:
        flag = 'YES'
    print(f'#{i} {flag}')