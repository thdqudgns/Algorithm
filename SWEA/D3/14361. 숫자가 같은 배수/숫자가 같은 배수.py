from itertools import permutations
for tc in range(1, int(input())+1):
    n = str(input())
    arr = []
    arr += list(permutations(n, len(n)))
    flag = 'impossible'

    # 조합으로 생성된 문자를 숫자로 변경한다.
    for i in range(len(arr)):
        arr[i] = int(''.join(arr[i]))

    # 숫자가 된 재배열들을 하나씩 확인하며 배수가 있는지 본다.
    for i in arr:
        if i > int(n) and i%int(n) == 0:
            flag = 'possible'
            break
    print(f'#{tc} {flag}')