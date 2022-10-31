T = int(input())
for i in range(1, T+1):
    N = int(input())
    print(f'#{i}', end=' ')
    for _ in range(N):
        print(f'1/{N}', end=' ')
    print()