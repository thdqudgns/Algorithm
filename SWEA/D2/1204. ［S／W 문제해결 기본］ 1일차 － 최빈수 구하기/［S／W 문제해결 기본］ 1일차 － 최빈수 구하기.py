T = int(input())
for _ in range(T):
    test_case = int(input())
    score_cnt = [0 for _ in range(101)]
    score_input = list(map(int, input().split()))
    for s in score_input:
        score_cnt[s] += 1
	
    score_cnt.reverse()
    ans = score_cnt.index(max(score_cnt))
    print(f'#{test_case} {100-ans}')