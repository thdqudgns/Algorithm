import sys
N, M = map(int, sys.stdin.readline().rstrip().split())
arr_num = dict()
arr_word = dict()
for i in range(1, N+1):
    inp = sys.stdin.readline().rstrip()
    arr_num[str(i)] = inp
    arr_word[inp] = str(i)
# print(arr_num)
# print(arr_word)
for _ in range(M):
    inp = sys.stdin.readline().rstrip()
    if inp.isalpha():
        print(arr_word[inp])
    else:
        print(arr_num[inp])