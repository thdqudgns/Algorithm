# 인원 수가 보다 클 때에만 저장, 아니면 continue
people = 0
a, b = 0, 0
num = 0
for i in range(4):
    a, b = map(int, input().split())
    people = people - a + b
    if people > num:
        num = people
print(num)