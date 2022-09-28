# 현재시간, 수행시간 입력
input_data = input().split(' ')
work = int(input())

input_hour = int(input_data[0])
input_minute = int(input_data[1])
input_second = int(input_data[2])

work += input_second

add_minute = work//60
second = work % 60

minute = input_minute + add_minute
add_hour = minute//60
minute = minute % 60

hour = input_hour + add_hour
hour = hour%24

print(hour, minute, second)