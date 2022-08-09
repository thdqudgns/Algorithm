# @ = *3
# % = +5
# # = -7

# 입력은 한 번에 받고, 출력도 한 번에 한다.
# 그러기 위해서 값을 저장해 놓아야 한다.

n = int(input())    # 테스트 케이스 개수
result = []     # 결과 저장 공간

def calculater(N, cal):
    if cal == '@':
        N *= 3
    elif cal == '%':
        N += 5
    elif cal == '#':
        N -= 7
    return float(N)

for i in range(n):
    cal = []  # 문자 저장 공간
    input_data = input().split(' ')
    num = float(input_data[0])
    for j in range(len(input_data)):
        cal.append(input_data[j])
        num = calculater(num, str(cal[j]))
    print(f'{num:.2f}')
