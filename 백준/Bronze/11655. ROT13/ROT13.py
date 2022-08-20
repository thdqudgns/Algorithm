word = list(input())
for i in range(len(word)):
    w = word[i]
    if 65 <= ord(w) < 78:
        word[i] = chr(ord(w) + 13)
    elif 78 <= ord(w) <= 90:
        word[i] = chr(ord(w) + 13 - 26)
    elif 97 <= ord(w) < 110:
        word[i] = chr(ord(w) + 13)
    elif 110 <= ord(w) <= 122:
        word[i] = chr(ord(w) + 13 - 26)

print(*word, sep='')

# 65 -> 78
# 77 -> 90
# 78 -> 91 - 26 = 65