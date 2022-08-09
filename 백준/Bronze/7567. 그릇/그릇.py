plate = input()
sum = 10
for i in range(len(plate)-1):
    if plate[i] == plate[i+1]:
        sum += 5
    else:
        sum += 10

print(sum)