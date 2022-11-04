week = {'MON':6,
        'TUE':5,
        'WED':4,
        'THU':3,
        'FRI':2,
        'SAT':1,
        'SUN':7}

T = int(input())
for i in range(1, T+1):
    w = input()
    try:
        result = week[w]
    except:
        result = -1
    print(f'#{i} {result}')