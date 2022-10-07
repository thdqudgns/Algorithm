from collections import deque
import sys

N = int(input())
deque = deque()

def play(command, num):
    if command == "push":
        deque.append(num)
    elif command == "pop":
        if len(deque) == 0:
            print(-1)
        else:
            print(deque.popleft())
    elif command == "size":
        print(len(deque))
    elif command == "empty":
        if len(deque) == 0:
            print(1)
        else:
            print(0)
    elif command == "front":
        if len(deque) == 0:
            print(-1)
        else:
            print(deque[0])
    elif command == "back":
        if len(deque) == 0:
            print(-1)
        else:
            print(deque[-1])

for _ in range(N):
    input_data = list(map(str, sys.stdin.readline().strip().split(' ')))
    command = input_data[0]
    num = 0
    if len(input_data) > 1:
        num = int(input_data[1])
    play(command, num)