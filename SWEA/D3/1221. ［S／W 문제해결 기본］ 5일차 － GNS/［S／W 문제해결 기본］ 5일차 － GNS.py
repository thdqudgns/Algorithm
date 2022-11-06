from collections import Counter
num = ["ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"]
T = int(input())
for tc in range(1, T+1):
    n = map(str, input().split())
    s = Counter(list(map(str, input().split())))
    result = ''
    for i in range(10):
        result += (num[i] + ' ')*s[num[i]]
    print(f'#{tc} {result}')