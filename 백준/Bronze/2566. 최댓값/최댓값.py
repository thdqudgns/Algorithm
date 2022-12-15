a = [[0 for _ in range(10)] for _ in range(10)]      # 배열
m = -27000  # 최댓값
x, y = 0, 0 # 행과 열

# print(a)

for i in range(1, 10):
    tmp = list(map(int, input().split()))
    for j in range(1, 10):
        a[i][j] = tmp[j-1]
        if tmp[j-1] > m:
            m = tmp[j-1]
            x = i
            y = j

# print(a)
print(m)
print(x, y)