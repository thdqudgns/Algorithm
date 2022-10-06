import sys
N = int(input())
arr1 = set(map(int, sys.stdin.readline().strip().split(' ')))
M = int(input())
arr2 = list(map(int, sys.stdin.readline().strip().split(' ')))
for i in arr2:
    if i in arr1:
        print(1)
    else:
        print(0)