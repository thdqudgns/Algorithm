T = int(input())
for i in range(1, T+1):
    numString = input()
    lastNum = int(numString[-1])
    if lastNum%2 == 0:
        print(f'#{i} {"Even"}')
    else:
        print(f'#{i} {"Odd"}')
