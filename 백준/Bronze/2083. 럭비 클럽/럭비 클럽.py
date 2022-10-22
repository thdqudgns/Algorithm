while True:
    name, age, weight = map(str, input().split())
    age = int(age)
    weight = int(weight)
    age_class = 'Junior'
    if name == '#':
        break
    if age > 17 or weight >= 80:
        age_class = 'Senior'
    print(name, age_class)