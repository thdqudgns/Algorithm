# 각 테스트 케이스마다 "Case #x: "를 출력한 다음, A+B를 출력한다. 테스트 케이스 번호는 1부터 시작한다.
N = int(input())

for i in range(1,N+1):
    input_data = input().split()
    A = int(input_data[0])
    B = int(input_data[1])
    print(f'Case #{i}: {A+B}')