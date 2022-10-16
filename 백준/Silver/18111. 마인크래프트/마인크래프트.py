import sys
from collections import Counter

n, m, inven = map(int, sys.stdin.readline().split())
ground = []
for _ in range(n): ground += map(int, sys.stdin.readline().split())  # 1차원 리스트로 해결하려 함
height, time = 0, 1000000000000000  
# 땅 고르기의 높이: 0에서 1씩 증가시키면서 완전 탐색
# 걸리는 시간: 최소 시간이 나오면, 바꿔서 저장함

min_h = min(ground)  # 땅의 최소 높이
max_h = max(ground)  # 땅의 최고 높이
_sum = sum(ground)  # 입력받은 높이의 합
ground = dict(Counter(ground))  # 각 높이의 개수를 세며 list를 dictionary로 변환 -> 같은 높이인 땅의 개수를 셈

for i in range(min_h, max_h + 1):   # 목표하는 최소 높이 ~ 최고 높이
    if _sum + inven >= i * n * m:   # 블록의 가용 개수가 '(현재 목표 높이)*땅면적' 이상일 때만
        cur_time = 0    # 걸리는 시간을 0으로 초기화
        for key in ground:  # 딕셔너리에 저장된 땅의 높이를 순회하며 (현재 같은 높이 별로 세어진 상태)
            if key > i:  # 현재 땅의 높이가 목표 높이 보다 높다면
                cur_time += (key - i) * ground[key] * 2  # (블록의 차이)*(똑같은 높이의 개수)*(제거할 때 걸리는 시간)
            elif key < i:  # 현재 땅의 높이가 목표 높이 보다 낮다면
                cur_time += (i - key) * ground[key]  # (블록의 차이)*(똑같은 높이의 개수)*(추가할 때 걸리는 시간)
        if cur_time <= time:  # 걸린 시간의 최솟값을 저장
            time = cur_time
            height = i  # 시간을 저장할 때, 그 높이도 같이 저장한다.

print(time, height)