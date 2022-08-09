import sys
K = int(sys.stdin.readline())
a = []

for i in range(K):
    input_data = int(sys.stdin.readline())
    if input_data == 0:
        a.pop()
    else:
        a.append(input_data)

print(sum(a))