def hansu(num) :
    hansu_cnt = 0
    for i in range(1, num+1):
        num_list = list(map(int, str(i)))   # 각 자리수를 배열로 저장한다
        if i < 100:
            hansu_cnt += 1  # 100보다 작으면 모두 한수 -> 그렇다고 한다.
        elif num_list[0]-num_list[1] == num_list[1]-num_list[2]:    # 숫자의 차이를 비교한다.
            hansu_cnt += 1  # x의 각 자리가 등차수열이면 한수
    return hansu_cnt

num = int(input())
print(hansu(num))