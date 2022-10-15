import sys
from collections import deque

input = sys.stdin.readline

n, m = map(int, input().split())
graph = []

for _ in range(n):
    graph.append(list(map(int, input().rstrip())))  # readline의 경우 맨 뒤에 '\n'까지 입력받으므로 제거해줘야 함

# 상하좌우
dx = [-1, 1, 0, 0]  # 상, 하
dy = [0, 0, -1, 1]  # 좌, 우

# BFS: 방문하는대로 이어짐
def bfs(x, y):
    queue = deque()         # 덱 사용: 양쪽에서 in, out / list와 함수 비슷함
    queue.append((x, y))    #

    while queue:
        x, y = queue.popleft()  # 들어온 순서대로 나간다

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            # nx, ny는 index로 쓰이기에 0 <= nx < n and 0 <= ny < m를 만족해야 한다.
            # graph[nx][ny] 의 수가 1이라 이동할 수 있으면 동작한다. (1이면 아직 방문 안했다는 뜻)
            # graph[nx][ny] 의 수가 1이 아니라면 이미 방문한 곳이기에 넘어간다.
            if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 1:
                queue.append((nx, ny))  # 큐에 넣고
                graph[nx][ny] = graph[x][y] + 1     # 이전의 공간에 1을 더하여 저장한다. -> 이동할 때마다 그 공간의 수를 1 증가시켜 바꿈.
                # print(graph[nx][ny])
    return graph[n - 1][m - 1]  # 마지막 위치는 이동한 개수만큼 더해졌으므로 그대로 출력하면 이동한 수가 나온다.


print(bfs(0, 0))