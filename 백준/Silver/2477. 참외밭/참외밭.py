# 1 -> 3
# 2 -> 4

N = int(input())
arr = []
for i in range(6):
    x, y = map(int, input().split())
    arr.append([x, y])

arr.append([arr[0][0], arr[0][1]])

bite = 0    # 깎여들어간 넓이
width = 0
length = 0
for i in range(6):
    # 깎여 들어갈 때의 넓이 구하기
    if arr[i][0] == 1 and arr[i+1][0] == 3:
        bite = arr[i][1] * arr[i+1][1]
    elif arr[i][0] == 2 and arr[i+1][0] == 4:
        bite = arr[i][1] * arr[i+1][1]
    elif arr[i][0] == 3 and arr[i+1][0] == 2:
        bite = arr[i][1] * arr[i+1][1]
    elif arr[i][0] == 4 and arr[i+1][0] == 1:
        bite = arr[i][1] * arr[i+1][1]

    # 가로, 세로 길이 구하기
    if arr[i][0] == 1 or arr[i][0] == 2:
        if arr[i][1] > width:
            width = arr[i][1]
    elif arr[i][0] == 3 or arr[i][0] == 4:
        if arr[i][1] > length:
            length = arr[i][1]

answer = ((width*length)-bite)*N
print(answer)