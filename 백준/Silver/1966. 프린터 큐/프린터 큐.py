import sys
from collections import deque
T = int(input())
for i in range(T):
    # N: 문서의 개수
    # M: M-1번째에 위치한 문서가 몇번 째로 출력되는가
    N, M = map(int, sys.stdin.readline().strip().split(' '))

    # 각각의 문서에 중요도가 표시된다.
    deque1 = deque(map(int, sys.stdin.readline().strip().split(' ')))
    # 중요도가 같아도 각 문서는 다른 문서다.
    deque2 = deque(j for j in range(N))

    # 몇번째 출력인지 카운트
    cnt = 1

    # M이 arr2에 없을 때까지 반복
    while M in deque2:
        if deque1[0] == max(deque1):
            deque1.popleft()
            deque2.popleft()
            cnt += 1
        else:
            deque1.append(deque1.popleft())
            deque2.append(deque2.popleft())

    print(cnt-1)