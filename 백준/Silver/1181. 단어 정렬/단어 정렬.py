import sys
input = sys.stdin.readline

N = int(input().rstrip())
arr = []
for i in range(N):
    w = input().rstrip()
    l = len(w)
    arr.append([w, l])
# print(arr)
arr = sorted(arr, key=lambda x: (x[1], x[0]))
# print(arr)

for i in range(len(arr)):
    try:
        if arr[i][0] == arr[i+1][0]:
            continue
        print(arr[i][0])
    except:
        print(arr[i][0])