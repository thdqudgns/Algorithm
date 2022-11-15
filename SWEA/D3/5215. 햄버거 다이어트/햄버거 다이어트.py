from itertools import combinations

for tc in range(1, int(input())+1):
    # N: 재료의 수
    # L: 제한 칼로리
    N, L = map(int, input().split())
    # arr: 재료에 대한 민기의 맛 점수[0]와 칼로리[1]
    arr = [[list(map(int, input().split()))] for _ in range(N)]
    # arr = sorted(arr, key=lambda x : x[0], reverse=True)
    # print(arr)

    # 칼로리의 합과, 그때의 맛 점수의 합을 배열로 구현해보자.
    # 칼로리의 합은 L이하
    maxScore = 0
    for i in range(1, N+1): # 조합의 범위를 잘 봐야 한다.
        for values in combinations(arr, i):
            testSumKcal = 0
            testSumTaste = 0
            # print(values)
            for j in range(len(values)):
                testSumKcal += values[j][0][1]
                testSumTaste += values[j][0][0]
            if testSumKcal <= L and testSumTaste > maxScore:
                maxScore = testSumTaste

    print(f'#{tc} {maxScore}')
