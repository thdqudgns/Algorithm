T = int(input())
 
for test_case in range(1,T+1):
    s=input()
    for i in range(1, 11):
        if s[:i] ==s[i:i*2]:
            res=i
            break;
    print("#%d %d" %(test_case, res))