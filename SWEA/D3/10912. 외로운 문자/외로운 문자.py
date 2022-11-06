# 10912. 외로운 문자
from collections import Counter
alpha = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
for tc in range(1, int(input())+1):
    s = Counter(input())    # xxyyzz -> Counter({'x': 2, 'y': 2, 'z': 2})
    for a in alpha:
        if s[a] % 2 == 0:
            s[a] = 0
    result = ''
    for a in alpha:
        if s[a] != 0:
            result += a
    if len(result) == 0:
        result = 'Good'

    print(f'#{tc} {result}')