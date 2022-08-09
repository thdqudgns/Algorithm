# 세 점의 좌표를 리스트에 저장
jum = []
for _ in range(3):
    jum.append(list(map(int, input().split())))
x,y = 0,0
# 나머지 한 점의 위치를 구하자
if jum[0][0] == jum[1][0]:
    x = jum[2][0]
elif jum[0][0] == jum[2][0]:
    x = jum[1][0]
elif jum[1][0] == jum[2][0]:
    x = jum[0][0]

if jum[0][1] == jum[1][1]:
    y = jum[2][1]
elif jum[0][1] == jum[2][1]:
    y = jum[1][1]
elif jum[1][1] == jum[2][1]:
    y = jum[0][1]

jum.append([x,y])
# print(jum)

print(x,y)