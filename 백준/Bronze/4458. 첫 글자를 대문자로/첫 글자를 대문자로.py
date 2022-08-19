n = int(input())
for i in range(n):
    word = str(input())
    print(word[0].upper()+word[1:])
    # upper()함수와 슬라이싱을 사용하여 첫 글자만 대문자로 하고,나머진 그대로 출력함