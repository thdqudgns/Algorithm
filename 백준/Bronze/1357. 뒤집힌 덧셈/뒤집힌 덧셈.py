def Rev(X):
    X = int(X[::-1])  # 문자열을 역순으로 정렬 후, 정수로 변환
    return X


a, b = input().split(' ')

result = Rev(str(Rev(a) + Rev(b))) # 정수로 반환받아 합친것을 다시 문자열로 변환하여 Rev(X)함수 적용

print(result)
