w = input()
cnt = 0
for i in range(len(w)):
    if 65 <= ord(w[i]) <= 67:
        cnt += 3
    elif 68 <= ord(w[i]) <= 70:
        cnt += 4
    elif 71 <= ord(w[i]) <= 73:
        cnt += 5
    elif 74 <= ord(w[i]) <= 76:
        cnt += 6
    elif 77 <= ord(w[i]) <= 79:
        cnt += 7
    elif 80 <= ord(w[i]) <= 83:
        cnt += 8
    elif 84 <= ord(w[i]) <= 86:
        cnt += 9
    elif 87 <= ord(w[i]) <= 90:
        cnt += 10

print(cnt)
