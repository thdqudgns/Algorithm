# 현재시간, 수행시간 입력
input_data = input().split(' ')
w = int(input())
# print(input_data)
# print(w)
h = int(input_data[0])
m = int(input_data[1]) + w
n = m//60

if m >= 60:
    m -= n*60
    h += n
    if h >= 24:
        h -= 24

print(h, m)
