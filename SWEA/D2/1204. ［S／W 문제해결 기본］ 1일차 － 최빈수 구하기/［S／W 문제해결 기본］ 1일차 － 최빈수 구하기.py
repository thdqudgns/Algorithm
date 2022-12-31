T = int(input())
for _ in range(T):
    test_case = int(input())
    score_cnt = [0 for _ in range(101)]
    score_input = list(map(int, input().split()))
    for s in score_input:
        score_cnt[s] += 1
     
    max = 0
    result_arr = []
     
    for i in range(101):
        if score_cnt[i] >= max:
            max = score_cnt[i]
            result_arr.append([max, i])
 
    result_arr.sort(key=lambda x: (-x[0], -x[1]))
    print(f'#{test_case} {result_arr[0][1]}')