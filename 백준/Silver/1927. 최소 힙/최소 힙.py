from sys import stdin
import heapq
input = stdin.readline
numbers = int(input())
heap = []

#Min Heap
for _ in range(numbers):
    num = int(input())
    if num != 0:
        heapq.heappush(heap, num)   # heap이라는 list에 num을 최소힙 방식으로 삽입한다.
    else:   # num이 0 이라면
        try:
            print(heapq.heappop(heap))
        except:
            # heap이 비어있어서 
            # 뽑아낼(heapq.heappop 할) 원소가 없다면
            print(0)    # 0을 출력함