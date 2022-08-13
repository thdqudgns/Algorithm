import sys
n = int(input())
for i in range(n):
    num, word = map(str, sys.stdin.readline().strip().split())
    word = list(word)
    word.pop(int(num)-1)
    print(''.join(word))

# - ''.join(리스트)''.join(리스트)를 이용하면 매개변수로 들어온 ['a', 'b', 'c']
# 이런 식의 리스트를 'abc'의 문자열로 합쳐서 반환해주는 함수인 것입니다.

# - '구분자'.join(리스트)'구분자'.join(리스트)를 이용하면 리스트의 값과 값 사이에
# '구분자'에 들어온 구분자를 넣어서 하나의 문자열로 합쳐줍니다.
# '_'.join(['a', 'b', 'c']) 라 하면 "a_b_c" 와 같은 형태로 문자열을 만들어서 반환해 줍니다.