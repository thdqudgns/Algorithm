T = 10
for tc in range(1, T + 1):
    N = int(input())
    words = []
    for _ in range(100):  # 100줄에 걸쳐서 데이터를 입력받음
        words.append(list(input()))
    trans_words = list(map(list, zip(*words)))  # 2차원 배열 뒤집기
    length = 1  # 최소 가로 길이 1

    # 가로 탐색
    for i in range(100):  # 0번째 줄부터 100번째 줄까지 탐색
        for j in range(100):  # 0번째 숫자부터 100번째 숫자까지 탐색
            for k in range(99, -1, -1):  # 긴 길이부터 탐색
                if words[i][j:k + 1] == words[i][j:k + 1][::-1]:
                    if length < k - j + 1:
                        length = k - j + 1
                        break
                    break
    # 세로 탐색
    for i in range(100):  # 0번째 줄부터 100번째 줄까지 탐색
        for j in range(100):  # 0번째 숫자부터 100번째 숫자까지 탐색
            for k in range(99, -1, -1):  # 긴 길이부터 탐색
                if trans_words[i][j:k + 1] == trans_words[i][j:k + 1][::-1]:
                    if length < k - j + 1:
                        length = k - j + 1
                        break
                    break

    print("#{} {}".format(tc, length))