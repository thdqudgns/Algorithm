import sys
n = int(input())
for i in range(n):
    a = list(map(int, sys.stdin.readline().strip().split()))
    a.pop(0)    # 첫번째 입력받은 수(= 학생수)를 제거함
    a.sort(reverse=True)
    gap = 0
    for j in range(len(a)-1):
        cha = a[j] - a[j+1]
        if cha > gap:
            gap = cha
    print('Class', i+1)
    print('Max %d, Min %d, Largest gap %d' %(max(a), min(a), gap))