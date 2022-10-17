# 1/1
# 1/2 2/1
# 3/1 2/2 1/3
# 1/4 2/3 3/2 4/1
# 5/1 4/2 3/3 2/4 1/5
#
# n층: n개
#
# M을 입력받았다고 한다면
# 이 M이 몇 층의 몇 번째인지 알 수 있을까?
#
# 각 층마다의 개수를 누적하면 된다

N = int(input())
floor = 1
cnt = 0
while N > cnt:
    cnt += floor
    floor +=1

floor = floor - 1 # N이 위치하고 있는 실제 층수 (맨 위가 1층..)
location = N - (cnt-floor) # 그 층에서 N이 위치하고 있는 자리

if floor%2 != 0: # 홀수층
    print(str(floor+1-location)+'/'+str(location))
else:   # 짝수층
    print(str(location)+'/'+str(floor+1-location))

# N: 3  / floor: 1 / cnt: 0
# N: 3  / floor: 2 / cnt: 1 (w)
# N: 3  / floor: 3 / cnt: 3 (w)
# floor: floor-1 = 2
# N - (cnt-(floor-1)) = 2
# ==> 2층의 2번째 수다.

# N: 4  / floor: 1 / cnt: 0
# N: 4  / floor: 1 / cnt: 1
# N: 4  / floor: 2 / cnt: 1 (w)
# N: 4  / floor: 3 / cnt: 3
# N: 4  / floor: 4 / cnt: 6 (w)

# N: 4  / floor: 4 / cnt: 6
# floor: floor-1 = 3
# N - (cnt-(floor-1)) = 1
# ==> 3층의 1번째 수다.