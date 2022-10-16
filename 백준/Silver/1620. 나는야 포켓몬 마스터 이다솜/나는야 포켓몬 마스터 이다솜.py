import sys
N, M = map(int, sys.stdin.readline().rstrip().split())
arr_num = dict()
arr_word = dict()
for i in range(1, N+1):
    inp = sys.stdin.readline().rstrip()
    arr_num[i] = inp
    arr_word[inp] = i
# print(arr_num)
# print(arr_word)
for _ in range(M):
    inp = sys.stdin.readline().rstrip()
    try:
        inp = int(inp)
    except:
        inp = inp

    if type(inp) is int:
        print(arr_num[inp])
    else:
        print(arr_word[inp])