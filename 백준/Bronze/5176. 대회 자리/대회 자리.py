import sys
n = int(sys.stdin.readline())
for i in range(n):
    a, b = map(int, sys.stdin.readline().strip().split())    # 참가자 수, 자리수
    c = []                              # 참가자들이 지정할 자리 입력받는 list
    for _ in range(a):
        c.append(int(sys.stdin.readline()))
    c = list(set(c))                          # 입력받은 자리를 집합으로 하여 중복제거함
    print(a - len(c))