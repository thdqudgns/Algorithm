for tc in range(1, int(input())+1):
    n = int(input())
    if n%2 == 0:
        print(f'#{tc} {-(n//2)}')
    else:
        print(f'#{tc} {(n//2)+1}')