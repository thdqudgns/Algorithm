for tc in range(1, int(input())+1):
    n = int(input())
    arr = sorted(map(int, input().split()))
    print(f'#{tc}', end=' ')
    print(*arr)