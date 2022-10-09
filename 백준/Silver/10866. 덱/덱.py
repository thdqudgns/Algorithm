from collections import deque
import sys

N = int(input())
deque = deque()

for _ in range(N):
    data = list(map(str, sys.stdin.readline().strip().split(' ')))
    com = data[0]
    if len(data) > 1:
        num = int(data[1])

    if com == "push_front":
        deque.appendleft(num)
    elif com == "push_back":
        deque.append(num)
    elif com == "pop_front":
        if len(deque) == 0:
            print(-1)
        else:
            print(deque.popleft())
    elif com == "pop_back":
        if len(deque) == 0:
            print(-1)
        else:
            print(deque.pop())
    elif com == "size":
        print(len(deque))
    elif com == "empty":
        if len(deque) == 0:
            print(1)
        else:
            print(0)
    elif com == "front":
        if len(deque) == 0:
            print(-1)
        else:
            print(deque[0])
    elif com == "back":
        if len(deque) == 0:
            print(-1)
        else:
            print(deque[-1])
