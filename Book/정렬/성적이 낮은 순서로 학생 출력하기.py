n = int(input())

array = []

for i in range(n):
    inputs = input().split()
    array.append((inputs[0], int(inputs[1])))

def score_sort(data):
    return data[1]

result = sorted(array, key=score_sort)

for i in result:
    print(i[0], end=' ')