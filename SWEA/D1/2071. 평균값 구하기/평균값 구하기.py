for t in range(1, int(input())+1):
    a = list(map(int, input().split()))
    print(f'#{t} {round(sum(a)/10)}')