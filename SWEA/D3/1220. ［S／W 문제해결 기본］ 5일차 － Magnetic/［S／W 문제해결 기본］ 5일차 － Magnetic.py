for i in range(1, 10+1):
    N = int(input())
    table = [list(map(int, input().split())) for _ in range(N)]
    # [print(table[i]) for i in range(N)]
    cnt = 0
    for j in range(100):
        stack = [0]
        for k in range(99, -1, -1):
            if table[k][j] == 0:
                continue
            # 열 기준으로 점검한다. 그래서 j가 뒤에 옴.
            if table[k][j] == 2:
                stack.append(table[k][j])
            if stack[-1] == 2 and table[k][j] == 1:
                stack.append(table[k][j])
                cnt += 1
        # print(stack)
        # print(cnt)
        # print()
    print(f'#{i} {cnt}')