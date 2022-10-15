n = int(input())
num = 666   # 해당 작품의 번호
cnt = 0     # 몇번째 작품인지
while 1:
    if '666' in str(num):
        cnt += 1
    if cnt == n:    # 작품 번째가 맞으면 출력
        print(num)
        break
    num += 1