N, k = map(int, input().split())
arr = sorted(map(int, input().split()))
cut = []
for i in range(k):
    cut.append(arr.pop(-1))
print(cut[-1])