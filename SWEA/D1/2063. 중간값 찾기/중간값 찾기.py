T = int(input())
a = list(map(int, input().split()))
a.sort()
print(a[T//2])