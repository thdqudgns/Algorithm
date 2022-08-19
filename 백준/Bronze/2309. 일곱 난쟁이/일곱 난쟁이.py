import sys

a = []

for i in range(9):
    a.append(int(sys.stdin.readline()))

two_false = sum(a) - 100    # 전체 합에서 100을 빼어, 가짜 난쟁이 둘의 키의 합을 이용한다.

for i in range(8):
    for j in range(i+1,9):
        if a[i] + a[j] == two_false:    # 모든 경우의 수에서, 가짜난쟁이 키의 합을 찾으면
            exit_1, exit_2 = a[i], a[j]
            a.remove(exit_1)            # 각 값을 저장하고, remove()함수로 제거한다. (중복이 없으므로 가능)
            a.remove(exit_2)
            break                       # break로 빠져나온다.
        else:
            continue
    if len(a) == 7:                     # 가짜 난쟁이를 찾아서 7명이 남으면 바깥 반복문도 멈춘다.
        break

a.sort()

for i in a:     # 하나씩 출력함
    print(i)