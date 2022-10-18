# 하노이의 탑:
# 한 번에 한 개의 원판만 다른 탑으로 옮길 수 있다.
# 쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.
# 공간은 3개다.

# 비어있는 공간 or 자신보다 큰 판이 깔려있는 원판을 찾는다. 이동한다.
# 3번째 공간으로 옮긴다.

def hanoi(N, start, end):  # 원반개수, 시작, 목표
    if N == 1:  # 원반이 하나라면 그냥 옮기면 된다.
        print(start, end)
        return
    hanoi(N-1, start, 6 - (start+end))
    print(start, end)
    hanoi(N-1, 6-(start+end), end)

N = int(input())
print(pow(2, N)-1)
hanoi(N, 1, 3)