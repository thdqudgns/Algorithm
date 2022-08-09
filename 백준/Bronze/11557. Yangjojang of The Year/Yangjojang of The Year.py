T = int(input())

for i in range(T):
    N = int(input())
    sul = []
    for j in range(N):
        a, b = map(str, input().split(' '))
        sul.append([a, int(b)])

        sul = sorted(sul, key=lambda x: x[1])
    print(sul[-1][0])