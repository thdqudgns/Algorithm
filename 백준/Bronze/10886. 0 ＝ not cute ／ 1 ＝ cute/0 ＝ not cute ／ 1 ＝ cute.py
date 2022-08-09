T = int(input())

cute, Ncute = 0, 0

for i in range(T):
    input_data = int(input())
    if input_data == 1:
        cute += 1
    else:
        Ncute += 1

if cute > Ncute:
    print('Junhee is cute!')
elif cute < Ncute:
    print('Junhee is not cute!')