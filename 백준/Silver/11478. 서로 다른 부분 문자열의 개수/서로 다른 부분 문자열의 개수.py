import sys
N = sys.stdin.readline().rstrip()
cut = {}
for i in range(1, len(N)+1):
    for j in range(len(N)):
        cut[N[j:j+i]] = 0
print(len(cut))