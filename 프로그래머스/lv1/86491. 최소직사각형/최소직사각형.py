def solution(sizes):
    # 리스트 x에서 큰 것들만 뽑아냄 -> 그 중에서 가장 큰 것
    y = list(max(x) for x in sizes)
    # 리스트 x에서 작은 것들만 뽑아냄 -> 그 중에서 가장 큰 것
    z = list(min(x) for x in sizes)
    return max(y) * max(z)