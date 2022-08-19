hamberger = []
drink = []
for i in range(3):
    hamberger.append(int(input()))
for i in range(2):
    drink.append(int(input()))
print(min(hamberger)+min(drink)-50)