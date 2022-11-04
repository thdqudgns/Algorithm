pw = {'0001101': 0,
      '0011001': 1,
      '0010011': 2,
      '0111101': 3,
      '0100011': 4,
      '0110001': 5,
      '0101111': 6,
      '0111011': 7,
      '0110111': 8,
      '0001011': 9}

def checkPassword(RealPw):
    sum = 0
    odd = 1
    for num in RealPw:
        if odd:
            sum += num*3
            odd = 0
        else:
            sum += num
            odd = 1
    # print(sum)
    if sum%10 == 0:
        return True
    else:
        return False

def foundPw(inputData, M):
    # 데이터를 뒤집어 저장
    tmpData = inputData[::-1]
    realData = []
    # 1이 등장하고부터 56자리 저장하고, 다시 뒤집는다.
    for i in range(M):
        if tmpData[i] == '1':
            realData = tmpData[i:i+56]
            realData = realData[::-1]
            break
    # print(realData)
    return realData

TC = int(input())
for tc in range(1, TC+1):
    N, M = map(int, input().split())
    inputData = [input() for _ in range(N)]
    pwData = []
    check = False
    for index in range(N):
        for innerIndex in range(N):
            if inputData[index][innerIndex] == '1':
                check = True
                break
        if check:
            pwData = foundPw(inputData[index], M)
            break
    # print(pwData)
    # arr = '01110110110001011101101100010110001000110100100110111011'
    RealPw = []
    sumRealPw = 0
    for i in range(0, 56, 7):
        RealPw.append(pw[str(pwData[i:i + 7])])
        sumRealPw += pw[str(pwData[i:i + 7])]
    # print(RealPw)

    if checkPassword(RealPw):
        print(f'#{tc} {sumRealPw}')
    else:
        print(f'#{tc} {0}')