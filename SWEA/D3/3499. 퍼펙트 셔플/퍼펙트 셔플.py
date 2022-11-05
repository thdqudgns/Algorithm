T = int(input())
for tc in range(1, T+1):
    n = int(input())
    card = list(map(str, input().split()))
    mid = n//2
    if n % 2 == 1:
        mid += 1
    deck1 = card[:mid]
    deck2 = card[mid:]
    suffle = []
    if n % 2 == 0:
        for i in range(mid):
            suffle.append(deck1[i])
            suffle.append(deck2[i])
    else:
        for i in range(mid):
            suffle.append(deck1[i])
            if i < mid-1:
                suffle.append(deck2[i])

    print(f'#{tc}', end=' ')
    print(*suffle)