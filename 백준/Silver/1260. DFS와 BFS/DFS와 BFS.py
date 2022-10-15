N,M,V = map(int,input().split())

#행렬 만들기
graph = [[0]*(N+1) for _ in range(N+1)]     # 인덱스 번호대로 사용하려고 (정점의 개수)+1 함
for i in range(M):
    a,b = map(int,input().split())
    graph[a][b] = graph[b][a] = 1           # a와 b를 연결해주는 간선을 표시함

#방문 리스트 행렬
visited1 = [0]*(N+1)        # (정점의 개수)+1 만큼 0으로 채운 리스트 -> DFS용
visited2 = visited1.copy()  # (정점의 개수)+1 만큼 0으로 채운 리스트 -> BFS용

#dfs 함수 만들기
def dfs(V):
    visited1[V] = 1 #방문처리
    print(V, end=' ')
    for i in range(1, N+1):
        if graph[V][i] == 1 and visited1[i] == 0:   # V가 i번과 간선으로 연결되어 있는데, 아직 방문을 안 했으면 방문
            dfs(i)
# 이어지는 순서대로 방문한다

#bfs 함수 만들기
def bfs(V):
    queue = [V]
    visited2[V] = 1 #방문처리
    while queue:
        V = queue.pop(0) #방문한 순서대로 출력
        print(V, end = ' ')
        for i in range(1, N+1):
            if(visited2[i] == 0 and graph[V][i] == 1):  # V가 i번과 간선으로 연결되어 있는데, 아직 방문을 안 했으면 방문
                queue.append(i)                         # 방문한 순서대로 queue에 넣음.
                visited2[i] = 1                         # 방문처리함으로써 이후에 또다시 큐에 넣지 않게 함.
# V와 연결되어있는 모든 노드를 방문하고,
# 방문한 순서대로 또 연결되어있는 모든 노드를 방문한다.

dfs(V)
print()
bfs(V)