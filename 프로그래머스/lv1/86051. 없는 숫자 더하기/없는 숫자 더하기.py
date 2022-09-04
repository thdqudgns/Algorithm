def solution(numbers):
    answer = -1
    number = [0,1,2,3,4,5,6,7,8,9]
    answer = sum([i for i in number if i not in numbers])
    return answer