import sys
input = sys.stdin.readline

arr = [int(input()) for i in range(int(input()))]
arr.sort()
[print(i) for i in arr]