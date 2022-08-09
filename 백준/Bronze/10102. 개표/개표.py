T = int(input())
simsa = input()
A, B = 0, 0
for s in simsa:
    if s == 'A':
        A += 1
    else:
        B += 1
if A > B:
    print('A')
elif A < B:
    print('B')
else:
    print('Tie')