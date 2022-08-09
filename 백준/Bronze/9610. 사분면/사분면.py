# Q1: 2
# Q2: 0
# Q3: 0
# Q4: 1
# AXIS: 2
Q1 = 0
Q2 = 0
Q3 = 0
Q4 = 0
AXIS = 0

def loca(v):
    if v[0] > 0 and v[1] > 0:
        global Q1
        Q1 += 1
    elif v[0] > 0 and v[1] < 0:
        global Q4
        Q4 += 1
    elif v[0] < 0 and v[1] > 0:
        global Q2
        Q2 += 1
    elif v[0] < 0 and v[1] < 0:
        global Q3
        Q3 += 1
    else:
        global AXIS
        AXIS += 1


n = int(input())

for i in range(n):
    x, y = map(int, input().split(' '))
    v = [x, y]
    loca(v)

print('Q1: ' + str(Q1))
print('Q2: ' + str(Q2))
print('Q3: ' + str(Q3))
print('Q4: ' + str(Q4))
print('AXIS: ' + str(AXIS))