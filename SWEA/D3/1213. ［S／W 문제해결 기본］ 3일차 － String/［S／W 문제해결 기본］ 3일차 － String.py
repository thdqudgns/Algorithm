for i in range(1, 11):
    N = int(input())
    search = input()
    search_len = len(search)
    first = search[0]

    arr = input()
    cnt = 0

    for j in range(len(arr)):
        if arr[j] == first:
            s = arr[j:j+search_len]
            if s == search:
                cnt += 1

    print(f'#{i} {cnt}')


