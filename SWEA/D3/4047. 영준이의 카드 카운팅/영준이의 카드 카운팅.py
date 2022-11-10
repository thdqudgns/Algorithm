# 4047. 영준이의 카드 카운팅
T = int(input())
for tc in range(1, T + 1):
    card = {'S': [False,True,True,True,True,True,True,True,True,True,True,True,True,True,],
            'D': [False,True,True,True,True,True,True,True,True,True,True,True,True,True,],
            'H': [False,True,True,True,True,True,True,True,True,True,True,True,True,True,],
            'C': [False,True,True,True,True,True,True,True,True,True,True,True,True,True,]}
    s = input()
    errorFlag = False
    for i in range(0, len(s), 3):
        index = int(s[i+1:i+3])
        if card[s[i]][index]:
            card[s[i]][index] = False
        else:
            errorFlag = True
            break
    S = len([i for i in card['S'] if i])
    D = len([i for i in card['D'] if i])
    H = len([i for i in card['H'] if i])
    C = len([i for i in card['C'] if i])
    if errorFlag:
        print(f'#{tc} {"ERROR"}')
    else:
        print(f'#{tc} {S} {D} {H} {C}')