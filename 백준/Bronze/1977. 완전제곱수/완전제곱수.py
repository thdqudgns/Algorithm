M = int(input())
N = int(input())

power = []
sum = 0
while M != N+1:
    root = int(M**(1/2))
    if M == root**2:
        power.append(M)
    M += 1

if len(power) != 0:
    for i in range(len(power)):
        sum += power[i]

    print(sum)
    print(power[0])
else: print(-1)