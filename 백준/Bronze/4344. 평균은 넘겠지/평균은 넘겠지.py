n = int(input())

for i in range(n):

    # 인원 및 점수 입력
    a = list(map(int, input().split()))

    # 인원수만 따로 저장 후, 점수만 남김
    num = a[0]
    a.pop(0)

    # 평균 저장
    avg = sum(a)/num
    
    # '점수>평균' 인원 비율 구하기
    cnt = 0

    for j in a:
        if j > avg:
            cnt += 1

    print(format((cnt/num*100),'.3f'),'%',sep='')