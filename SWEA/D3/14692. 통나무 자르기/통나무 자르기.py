T = int(input())
for tc in range(1, T+1):
    n = int(input())
    result = ''
    if n % 2 == 0:
        result = 'Alice'
    else:
        result = 'Bob'

    print(f'#{tc} {result}')