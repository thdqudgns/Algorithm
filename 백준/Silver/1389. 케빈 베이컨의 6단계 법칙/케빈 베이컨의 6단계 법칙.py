# https://velog.io/@bye9/%EB%B0%B1%EC%A4%80%ED%8C%8C%EC%9D%B4%EC%8D%AC-1389-%EC%BC%80%EB%B9%88-%EB%B2%A0%EC%9D%B4%EC%BB%A8%EC%9D%98-6%EB%8B%A8%EA%B3%84-%EB%B2%95%EC%B9%99

# 각 친구와의 관계를 양방향으로 relation딕셔너리로 나타내었다.
# 그리고 bfs함수를 통해 각 유저의 케빈 베이컨 수를 구한다.
# 함수 실행 시마다 bacon리스트는 다음과 같다.
# [0, 0, 2, 1, 1, 2][0, 2, 0, 1, 2, 3]
# [0, 1, 1, 0, 1, 2][0, 1, 2, 1, 0, 1]
# [0, 2, 3, 2, 1, 0]
# 이를 합한 값 중 가장 작은 사람의 번호(index+1)를 구해주면 답이다.

from collections import deque


def bfs(num, n):
    bacon = [0] * (n + 1)
    visited = [num]
    queue = deque()
    queue.append(num)

    while queue:
        k = queue.popleft()
        for i in relation[k]:
            if i not in visited:
                bacon[i] = bacon[k] + 1
                visited.append(i)
                queue.append(i)

    return sum(bacon)


n, m = map(int, input().split())
relation = {i: [] for i in range(1, n + 1)}
for i in range(m):
    a, b = map(int, input().split())
    relation[a].append(b)
    relation[b].append(a)

result = []
for num in range(1, n + 1):
    result.append(bfs(num, n))

print(result.index(min(result)) + 1)