# 답지보고 품

a = input().split('-')  # '-'를 기준으로 나눈다.
sum = 0
for i in a[0].split('+'):   # '+'를 기준으로 나눠 더한다
    sum += int(i)
for i in a[1:]:
    for j in i.split('+'):  # '+'를 기준으로 나눠 뺀다
        sum -= int(j)
print(sum)