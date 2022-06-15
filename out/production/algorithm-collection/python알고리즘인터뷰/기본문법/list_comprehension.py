# date: 22.06.13
# page 80

# 리스트 컴프리헨션
print(list(map(lambda x: x + 10, [1, 2, 3])))

# 위와 아래는 동치
print([n * 2 for n in range(1, 10 + 1) if n % 2 == 1])

a = []
for n in range(1,10+1):
    if n % 2 == 1:
        a.append(n*2)
print(a)