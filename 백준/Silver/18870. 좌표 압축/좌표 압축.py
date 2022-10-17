import sys
input = sys.stdin.readline
N = int(input())
arr = list(map(int, input().split()))
arr_set = sorted(set(arr))
arr_dict = {}
# [-10 -9 2 4]
for i in range(len(arr_set)):
    arr_dict[arr_set[i]] = i
    # set이니까 중복이 없고, 정렬했으니까 순서대로인 상황에서
    # 해당 수의 인덱스가 곧 자신보다 작은 수의 개수를 나타낸다는 걸 사용함.

for i in arr:
    print(arr_dict[i], end=' ')
