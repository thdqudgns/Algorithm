import sys

def play(com, num):
    if com == "push":
        stack.append(num)
    elif com == "pop":
        if len(stack) == 0:
            print(-1)
        else:
            pop = stack.pop()
            print(pop)
    elif com == "size":
        print(len(stack))
    elif com == "empty":
        if len(stack) == 0:
            print(1)
        else:
            print(0)
    elif com == "top":
        if len(stack) == 0:
            print(-1)
        else:
            print(stack[-1])

N = int(sys.stdin.readline())
stack = []
for _ in range(N):
    arr = list(map(str, sys.stdin.readline().strip().split(' ')))
    com = arr[0]
    num = 0
    if len(arr) > 1:
        num = int(arr[1])
    play(com, num)