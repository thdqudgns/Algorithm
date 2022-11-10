for tc in range(1, int(input())+1):
    arr=list(input().split())
    n=int(arr.pop(0))
    cur_B, cur_O = 1, 1
    time_B, time_O = 0, 0
    for i in range(n):
        if arr[i*2]=='B':
            int_a=int(arr[i*2+1])
            time_B+=abs(int_a-cur_B)
            if time_B<=time_O:
                time_B+=time_O-time_B+1
            else:
                time_B+=1
            cur_B=int_a
        else:
            int_a=int(arr[i*2+1])
            time_O+=abs(int_a-cur_O)
            if time_O<=time_B:
                time_O+=time_B-time_O+1
            else:
                time_O+=1
            cur_O=int_a
    print(f"#{tc} {max(time_B, time_O)}")