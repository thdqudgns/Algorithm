import sys
test_case = int(input())

for _ in range(test_case):
    input_data = sys.stdin.readline().split(' ')
    A = int(input_data[0])
    B = int(input_data[1])
    print(A+B)