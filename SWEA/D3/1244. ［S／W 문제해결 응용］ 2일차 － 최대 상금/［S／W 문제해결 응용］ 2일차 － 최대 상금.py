def dfs(s, count):
    global result
 
    if count == m:
        # print(s)
        x = int(s)
        result = max(result, x)
        return
 
    for i in range(len(data) - 1):
        for j in range(i + 1, len(data)):
            # print('i, j',i, j)
            data[i], data[j] = data[j], data[i]
            new = ''.join(map(str, data))
            if (new, count) not in visited: #중복방지
                visited.append((new, count))
                dfs(new, count + 1)
            data[i], data[j] = data[j], data[i]
 
 
tc = int(input())
for t in range(1, tc + 1):
    s, m = input().split()
    m = int(m)
    data = []
    for i in range(len(s)):
        data.append(int(s[i]))
    # print(data)
    x = ''.join(map(str, data))
    # print('x',x)
    visited = []
    result = 0
    dfs(s, 0)
    print('#{} {}'.format(t, result))