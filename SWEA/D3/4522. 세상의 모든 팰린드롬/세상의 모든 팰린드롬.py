t = int(input())
for tc in range(1, t+1):
    s = input()
    n = len(s)
    result = 'Exist'
    for i in range(n//2):
        if s[i] != s[-(i+1)] and s[i] != '?' and s[-(i+1)] != '?':
         result = 'Not exist'
    print(f'#{tc} {result}')