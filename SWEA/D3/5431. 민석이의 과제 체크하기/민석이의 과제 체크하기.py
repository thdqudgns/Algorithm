T = int(input())
for tc in range(1, T+1):
    student_cnt, submit_cnt = map(int, input().split())
    submit_num_set = set(map(int, input().split()))
    no_submit = []
    for i in range(1, student_cnt+1):
        if i not in submit_num_set:
            no_submit.append(i)
    print(f'#{tc}', end=' ')
    print(*no_submit)