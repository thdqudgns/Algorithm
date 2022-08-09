a = []
for _ in range(10):
    a.append(int(input()) % 42)
# 10에서 겹치는 수만큼 빼주려고 했다. -> 실패
# cnt = 10
# for i in range(10):
#     for j in range((i+1), len(a)):
#         if a[i] == a[j]:
#             a.pop(a.index(a[j]))
#             cnt -= 1
# print(cnt)
#print(a)

# set을 사용하여 집합의 특성을 사용함.
a = set(a)
print(len(a))