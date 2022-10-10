from sys import stdin

n = stdin.readline().rstrip()
card = list(map(int,stdin.readline().split()))
m = stdin.readline().rstrip()
test = list(map(int,stdin.readline().split()))

# 해쉬맵 이용 ( 파이썬에서는 딕셔너리 )
hash = {}

for i in card:
    if i in hash:
        hash[i] += 1
    else:
        hash[i] = 1

# print(hash)
# {6: 1, 3: 2, 2: 1, 10: 3, -10: 2, 7: 1}
# 딕셔너리 자체를 사용하면 입력받은 순서대로 정렬된다.
# 6 3 2 10 -10 7

for i in test:
    if i in hash:
        print(1, end=' ')
    else:
        print(0, end=' ')