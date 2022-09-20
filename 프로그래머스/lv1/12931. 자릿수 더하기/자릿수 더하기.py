def solution(n):
    mok = n
    answer = 0
    
    while mok != 0:
        answer += mok%10
        mok //= 10

    # [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    # print('Hello Python')

    return answer