w = input()
arr = []
for i in range(len(w)):
    arr.append(w[i:])
arr.sort()
[print(i) for i in arr]