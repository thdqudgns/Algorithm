string = input()
alphabet = 'abcdefghijklmnopqrstuvwxyz'
for i in alphabet:
    print(string.find(i), end=' ')
    
# find 함수는 찾는 문자가 없으면 -1을 출력한다