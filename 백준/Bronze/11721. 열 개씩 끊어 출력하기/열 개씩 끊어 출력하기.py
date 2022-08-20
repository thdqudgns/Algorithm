w = str(input())    # 문자열로 입력받으면 빠른가?
for i in range(0, len(w), 10):  # 10씩 건너뛰도록 함
    print(w[i:i+10])
# print(w[0:10])
# print(w[10:20])
# print(w[20:30])
# print(w[30:40])