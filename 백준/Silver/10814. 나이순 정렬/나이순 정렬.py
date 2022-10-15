import sys
input = sys.stdin.readline

T = int(input().rstrip())
cnt = 0
arr = []
for _ in range(T):
    age, name = map(str, input().rstrip().split())
    age = int(age)
    arr.append([age, name, cnt])
    cnt += 1
arr = sorted(arr, key=lambda x: (x[0], x[2]))
[print(arr[i][0], arr[i][1]) for i in range(T)]