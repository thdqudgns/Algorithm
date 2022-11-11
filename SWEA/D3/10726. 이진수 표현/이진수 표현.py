for tc in range(1, int(input())+1):
    N, M = map(int, input().split())
    binary = str(format(M, 'b'))[::-1][:N]
    test = '1'*N
    print(f'#{tc} {"ON"}') if binary == test else print(f'#{tc} {"OFF"}')