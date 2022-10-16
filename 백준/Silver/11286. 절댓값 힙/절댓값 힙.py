# https://velog.io/@highcho/Algorithm-baekjoon-11286

import sys, heapq

min_heap = []
max_heap = []
n = int(sys.stdin.readline())
for i in range(n):
	num = int(sys.stdin.readline())
	if num > 0: # 양수일 때 최소 힙
		heapq.heappush(min_heap, num)
	elif num < 0: # 음수일 때 최대 힙
		heapq.heappush(max_heap, -num)
	else:
		if min_heap: # 최소 힙에 값이 존재하고
			if max_heap: # 맥스 힙에도 값이 존재할 때
				if min_heap[0] < max_heap[0]: # 최소 힙이 더 작은 경우에는
					print(heapq.heappop(min_heap)) # 최소 힙 출력
				else: # 최대 힙이 더 작은 경우에는
					print(-heapq.heappop(max_heap)) # 최대 힙 * -1 출력
			else: # 최소 힙만 존재할 때
				print(heapq.heappop(min_heap)) # 최소 힙 출력
		elif max_heap: # 최대 힙만 존재할 때
			print(-heapq.heappop(max_heap)) # 최대 힙 출력
		else: # 둘 다 존재하지 않을 때
			print(0)