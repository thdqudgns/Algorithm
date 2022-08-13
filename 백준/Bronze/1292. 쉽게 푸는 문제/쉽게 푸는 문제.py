import sys
a, b = map(int, input().split())
arr = []
arr_sum = []
for i in range(1, 100):
    for j in range(1, i+1):
        arr.append(i)

arr_sum = arr[a-1:b]
# print(arr_sum)
print(sum(arr_sum))