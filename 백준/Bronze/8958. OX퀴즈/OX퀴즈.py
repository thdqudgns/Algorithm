n = int(input())

for i in range(n):
    check = input()     # OX의 입력
    score = 0   # O에 따른 점수
    cnt = 0     # O의 반복횟수 세기
    for c in check:     # check리스트의 요소들을 하나씩 꺼낸다
        if c == 'O':    # O이 반복되는 카운트만큼 더해주자
            cnt += 1
            score += cnt
        elif c == 'X': # X면 cnt 초기화
            cnt = 0
    print(score)