n = int(input())
a, b = 100, 100

for i in range(n):
    A, B = map(int, input().split(' '))
    if A > B:
        b -= A
    elif A < B:
        a -= B
    else:
        continue

print(a)
print(b)