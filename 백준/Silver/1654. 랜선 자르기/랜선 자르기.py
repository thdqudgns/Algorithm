from sys import stdin

input = stdin.readline
k, n = map(int, input().rstrip().split())
arr = [int(input()) for _ in range(k)]
end = sum(arr)//n

def line_count(mid):    # mid로 나누면 몇개의 선이 되는가?
    count = 0
    for i in arr:
        count += i//mid     # arr에 들어있는 원소마다 mid로 나누었을 때 나오는 개수를 더함
    return count

def binarySearch(start, end, n):
    if start > end:
        return end
    mid = (start + end) // 2
    count = line_count(mid)
    if count >= n:  # 선의 개수가 요구하는 것보다 많거나 같으면, 길이를 늘려서 나오는 양을 줄여야지.
        return binarySearch(mid+1, end, n)
    else:   # 선의 개수가 요구하는 것보다 적으면, 길이를 줄여서 나오는 양을 늘려야지
        return binarySearch(start, mid-1, n)

print(binarySearch(1, end, n))
