# 각 인덱스가 x축의 위치
# 각 [0,0] 쌍이 해당 x에서의 최소와 최대
arr = [[0 for _ in range(101)] for _ in range(101)]
s = 0
for _ in range(4):
    x1, y1, x2, y2 = map(int, input().split())
    # 각 x축 마다 y값의 최대 - 최소 하여 높이를 구하면 높이가 넓이가 된다. 이것을 합한다.
    for i in range(x1, x2):
        for j in range(y1, y2):
            if arr[i][j] == 0:
                arr[i][j] = 1
                s += 1

print(s)