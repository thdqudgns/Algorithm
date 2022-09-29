# 새거는 넣고, 중복은 뺀다.
# not in 사용 가능할까?

T = int(input())
cnt = T
for _ in range(T):
    input_data = input()
    arr = []
    for i in range(len(input_data)):
        if i != len(input_data)-1 and input_data[i] == input_data[i+1]:
            continue
        else:
            arr.append(input_data[i])   # 중복이 제거되어 저장
    # print(arr)
    # 앞에 있는 알파벳이 또 나온다면? cnt -1
    arr2 = []
    for i in arr:
        if i in arr2:   # not in이 아니라 in을 사용함
            cnt -= 1
            break
        else:
            arr2.append(i)

print(cnt)

