from collections import Counter
T = int(input())
for tc in range(1, T+1):
    s = input()
    a = s[0]
    b = s[1]
    c = s[2]
    d = s[3]
    count = Counter([a,b,c,d])
    result = 'No'
    if len(count) == 2 and count[a] == 2 and count[b] == 2 and count[c] == 2:
        result = 'Yes'
    print(f'#{tc} {result}')