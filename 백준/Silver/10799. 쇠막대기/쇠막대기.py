# 쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 주어졌을 때,
# 잘려진 쇠막대기 조각의 총 개수를 구하는 프로그램을 작성하시오.
w = input()
# () = 레이저
# (  ) = 쇠막대기
# () ( ( ( () () ) ( () ) () ) ) ( () )
left, right = 0, 0
left_cnt = 0
sum = 0
for i in range(len(w)):
    ray = 0
    if w[i] == '(':
        left += 1
        left_cnt += 1
    elif w[i] == ')':
        right += 1
        left_cnt -= 1
    if i>0 and w[i-1] == '(' and w[i] == ')':
        ray = 1
    if ray == 1:
       sum += ray*left_cnt
    if i > 0 and w[i-1] == ')' and w[i] == ')':
        sum += 1
    # print(w[i], 'left (: ', left, 'right ): ', right, 'ray: ', ray, 'left_cnt: ', left_cnt, '개수: ', sum)

print(sum)
