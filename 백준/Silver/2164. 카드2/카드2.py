# 스택에 카드가 오름차순으로 들어가있다. 위:1, 아래:N
# 가장 위에 있는 카드를 버리고, 그 다음수를 맨 밑에 넣는다.
# 카드가 한 장 남을 때까지 반복하면, 마지막에 남는 카드는?

import sys
from collections import deque

N = int(sys.stdin.readline().strip())
queue = deque()

for i in range(N, 0, -1):
    queue.append(i)

while len(queue) != 1:
    queue.pop()
    queue.insert(0, queue.pop())

print(queue[0])