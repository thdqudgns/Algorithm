# 스택에 push하는 순서는 오름차순
# 임의의 수열이 주어졌을 때, 그 수열을
# 오름차순 스택에서 뽑아내어 만들 수 있는지 묻는다.
# 만들 수 있다면 어떤 순서로 push(+)와 pop(-)연산을 수행해야 하는지 출력한다.
import sys
n = int(sys.stdin.readline().strip())

stack = []
operator_list = []
up_num = 1
end = 0

for i in range(n):
    # 숫자를 입력받는다
    input_num = int(sys.stdin.readline().strip())

    # 숫자를 오름차순으로 증가시키면서 stack에 저장한다.
    # 입력받은 수보다, 오름차순으로 증가하고 있는 숫자가 작다면 stack에 넣는다.
    while up_num <= input_num:
        stack.append(up_num)
        operator_list.append("+")
        up_num += 1

    # 스택의 마지막 값이 입력받은 수와 같다면 꺼낸다.
    if stack[-1] == input_num:
        stack.pop()
        operator_list.append("-")
    # 입력받은 수가 스택의 마지막 값보다 큰데도,
    # 뽑아낼 수 없는 상황이라면 종료한다.
    else:
        end = 1
        break

if end == 1:
    print("NO")
else:
    for op in operator_list:
        print(op)
        