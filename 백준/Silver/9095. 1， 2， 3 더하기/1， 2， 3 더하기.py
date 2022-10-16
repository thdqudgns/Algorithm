# 1<= n <= 11
# 1개 이상의 수로 표현: 1, 2, 3 하나의 수도 사용 가능하다
# 1 2 4 7 13, ....  => 규칙을 찾아 리스트 먼저 만들기

arr = [0, 1, 2, 4]
for i in range(4, 12):
    a = arr[i-1] + arr[i-2] + arr[i-3]
    arr.append(a)

for _ in range(int(input())):
    print(arr[int(input())])