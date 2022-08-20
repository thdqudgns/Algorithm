arr = [0 for i in range(26)]
# 입력받은 문자 하나씩 체크하면서, 문자에 해당하는 index의 값을 1씩 증가시킨다.
w = str(input())
for i in w:
    arr[ord(i)-97] += 1
for i in arr:
    print(i,end=' ')