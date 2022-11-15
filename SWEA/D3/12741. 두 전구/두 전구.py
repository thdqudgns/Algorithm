arr = []
t = int(input())
for tc in range(1, t+1):
    a, b, c, d = map(int, input().split())
    s = max(a, c)
    l = min(b, d)
    result = l-s
    if result < 0:
        result = 0
    arr.append(result)

[print(f'#{i+1} {arr[i]}') for i in range(t)]