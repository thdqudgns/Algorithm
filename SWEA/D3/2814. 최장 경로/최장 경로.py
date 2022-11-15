def getLength(connection, sn, s, stack):
    global answer
 
    recurse = False
    for i in range(N):
        if connection[s][i] and i not in stack :
            # print(sn, s, i)
            recurse = True
            connection[s][i] = False
            connection[i][s] = False
            getLength(connection, sn, i, stack + [i])
            connection[i][s] = True
            connection[s][i] = True
 
    if not recurse:
        answer = max(len(stack), answer)
 
 
def deep_copy(ref):
    copied = [[False for _ in range(N)] for _ in range(N)]
    for i in range(N):
        for j in range(N):
            copied[i][j] = ref[i][j]
         
    return copied
 
 
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N, M = map(int, input().split())
 
    connection = [[False for _ in range(N)] for _ in range(N)]
 
    for _ in range(M):
        x, y = map(int, input().split())
        connection[x-1][y-1] = True
        connection[y-1][x-1] = True
     
    answer = 0
    tmp_connection = deep_copy(connection)
    for i in range(N):
        length = getLength(connection, i, i, [i])
        # answer = max(answer, length)
        connection = deep_copy(tmp_connection)
     
    print(f"#{test_case} {answer}")