T = int(input())    
 
def sol():
    li = list(input().split())
    robots = {'O' : [1,0], 'B': [1,0]}
    ans = 0
    for i in range(1, len(li)-1, 2):
        name = li[i]
        button = int(li[i+1])
        dist = abs(button - robots[name][0])
        robot_sec = ans - robots[name][1]
        ans += 1 if dist <= robot_sec else (dist-robot_sec+1)
        robots[name] = [button, ans]
    return ans
 
for tc in range(1, T+1):
    print(f'#{tc} {sol()}')