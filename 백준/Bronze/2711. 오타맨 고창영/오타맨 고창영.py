import sys
n = int(input())
for i in range(n):
    num, word = map(str, sys.stdin.readline().strip().split())
    word = list(word)
    word.pop(int(num)-1)
    for j in word:
        print(j, end='')
    print()