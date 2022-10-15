x,y,w,h = map(int, input().split())
r = [x,y,w-x,h-y]
print(min(r))