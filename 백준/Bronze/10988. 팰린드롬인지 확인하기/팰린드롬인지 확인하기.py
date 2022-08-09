word = input()
cnt = 0
for i in range(len(word)//2):
    if word[i] == word[-(i+1)]:
        cnt += 1

if cnt == len(word)//2:
    print(1)
else:
    print(0)