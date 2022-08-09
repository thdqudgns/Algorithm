T = int(input())

for _ in range(T):
    n, word = input().split(' ')
    for j in range(len(word)):
        print(word[j]*int(n), end='')
    print()