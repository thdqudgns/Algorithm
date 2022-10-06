import sys
N = int(sys.stdin.readline())
for _ in range(N):
    T = sys.stdin.readline()
    T = T.replace("\n", "")
    if len(T) != 0:
        while "()" in T:
            T = T.replace("()", "")
        if len(T) == 0:
            print("YES")
        else:
            print("NO")