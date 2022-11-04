t = int(input())
for tc in range(1, t + 1):
    date = int(input())     # 연속된 날짜
    priceList = list(map(int, input().split()))     # 가격 list
    benefit = 0     # 이익
    while date > 1:
        # priceList 중에서 가장 큰 수의 index를 저장함
        idx = priceList.index(max(priceList))

        # priceList[idx]: 가장 큰 수
        # idx: 가장 큰 수의 인덱스지만, 이전의 값들의 개수와 같다.
        # sum(priceList[:idx]): 이전의 값들의 총합
        # 따라서 가장 큰 수 이전까지의 이익을 계산한다.
        benefit += priceList[idx] * idx - sum(priceList[:idx])

        # 가격 리스트, 날짜 수를 변경
        priceList = priceList[(idx + 1):]   # 가장 큰 수 이후의 값들로 새로 생성
        date -= idx + 1
    print(f'#{tc} {benefit}')