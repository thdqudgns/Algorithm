import sys
s = []      # 맨 처음 입력받을 list -> 나중에 정렬해서 가장 높은 점수 5개의 합을 구한다.
ss = []     # 그대로 유지시켜, 높은 점수 5가지의 index를 알아낼 list
loc = []    # 알아낸 index를 저장할 list
sum = 0     # 가장 높은 수 5개를 합하여 저장할 변수

for i in range(8):
    s.append(int(sys.stdin.readline()))  # input() 보다 훨씬 빠르다
    ss.append(s[i])     # ss는 입력받은대로 있다.

s.sort()    # s는 정렬된다.

for i in range(7, 2, -1):
    sum += s[i]
    loc.append(ss.index(s[i])+1)

loc.sort()  # 인덱스의 순서대로 출력하기 위해 정렬함

print(sum)  # 합 먼저 출력

for i in loc:
    print(i, end=' ')    # 가장 높은 점수 5개의 index(순서)를 출력