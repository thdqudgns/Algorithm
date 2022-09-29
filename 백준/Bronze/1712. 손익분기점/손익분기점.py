A, B, C = map(int, input().split())
n = 0
if C <= B:
    n = -1
elif C > B:
    n = (A//(C-B)) + 1
print(n)