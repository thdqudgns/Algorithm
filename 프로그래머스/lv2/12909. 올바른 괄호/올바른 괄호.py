def solution(s):
    # 함수를 완성하세요
    open_cnt = 0
    for c in s:
        if c == '(':
            open_cnt += 1
        elif c == ')':
            open_cnt -= 1
            if open_cnt < 0:
                return False
    return open_cnt == 0