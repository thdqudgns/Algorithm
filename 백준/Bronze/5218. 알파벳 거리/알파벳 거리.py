n = int(input())
for i in range(n):
    a, b = input().split()
    print('Distances:', end=' ')
    for j in range(len(a)):
        aa, bb = int(ord(a[j])), int(ord(b[j]))
        if aa <= bb:
            cha = bb - aa
        else:
            cha = bb + 26 - aa
        print(cha, end=' ')
    print()