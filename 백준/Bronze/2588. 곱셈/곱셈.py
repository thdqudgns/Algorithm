A = int(input()) # A는 계속 곱하므로 숫자 그대로 둔다
B = input() # B는 문자열로 둔다

#print(A * int(B[2])) # A * 일의자리
#print(A * int(B[1])) # A * 십의자리
#print(A * int(B[0])) # A* 백의자리
for i in range(3,0,-1):
    print(A * int(B[i-1]))
print(A * int(B))