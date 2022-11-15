T = int(input())
for case in range(1, T+1):
    N = input()
    m = M = int(N)
    for i in range(len(N)-1):
        for j in range(i+1, len(N)):
            if i == 0 and N[j] == '0':
                continue
            tmp = int(N[:i] + N[j] + N[i+1:j] + N[i] + N[j+1:])
            m = min(m, tmp)
            M = max(M, tmp)
    print(f"#{case} {m} {M}")