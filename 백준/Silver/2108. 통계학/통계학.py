from collections import Counter
import sys
N = int(sys.stdin.readline())
arr = []
for i in range(N):
    arr.append(int(sys.stdin.readline()))

print(round(sum(arr)/N))

arr.sort()
two = arr[N//2]
four = arr[-1]-arr[0]

print(two)

count = Counter(arr).most_common()

if len(count) > 1:
    if count[0][1] == count[1][1]:
        print(count[1][0])
    else:
        print(count[0][0])
else:
    print(count[0][0])

print(four)

