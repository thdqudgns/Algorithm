import sys
input = sys.stdin.readline
arr = [input().rstrip() for i in range(int(input()))]
arr = list(set(arr))
arr.sort()
arr.sort(key=lambda x:len(x))
[print(i) for i in arr]