T = int(input())
for i in range(1, T+1):
    word = input()
    length = len(word)
    first = ''
    second = ''
    third = ''
    forth = ''
    fifth = ''
    for i in range(length):
        if i == 0:
            first += '..#..'
            second += '.#.#.'
            third += '#.'+word[i]+'.#'
            forth += '.#.#.'
            fifth += '..#..'
        else:
            first += '.#..'
            second += '#.#.'
            third += '.' + word[i] + '.#'
            forth += '#.#.'
            fifth += '.#..'
    print(first)
    print(second)
    print(third)
    print(forth)
    print(fifth)

