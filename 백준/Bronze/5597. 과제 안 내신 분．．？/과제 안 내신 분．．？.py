arr = set(i for i in range(1, 31))
arr_new = set(int(input()) for i in range(28))
result = sorted(arr - arr_new)
[print(i) for i in result]