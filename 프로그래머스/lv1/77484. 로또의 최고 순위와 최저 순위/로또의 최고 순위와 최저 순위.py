def solution(lottos, win_nums):
    answer = []
    rank = [6,6,5,4,3,2,1]
    cnt = len(list(i for i in lottos if i in win_nums))
    cnt_zero = len(list(i for i in lottos if i == 0))
    cnt_max = cnt + cnt_zero    # cnt_min  = cnt
    # answer = [6 if 7-cnt_max == 7 else 7-cnt_max, 6 if 7-cnt >= 6 else 7-cnt ]
    answer = [rank[cnt_max], rank[cnt]]
    # print(answer)
    return answer