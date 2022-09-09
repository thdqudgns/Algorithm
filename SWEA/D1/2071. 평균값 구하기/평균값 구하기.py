T = int(input())
for test_case in range(1, T + 1):
    b = [ i for i in list(map(int, input().split())) ]
    print('#%d %d' % (test_case,round(sum(b)/len(b))))