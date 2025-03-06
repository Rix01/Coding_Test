t = int(input())
fibo = [[0 for i in range(2)] for j in range(41)]

def hap(arr, a, b):
    result = [0, 0]
    result[0] = arr[a][0] + arr[b][0]
    result[1] = arr[a][1] + arr[b][1]
    return result

fibo[0] = [1, 0]
fibo[1] = [0, 1]

for i in range(2, 41):
    fibo[i] = hap(fibo, i-1, i-2)

for i in range(t):
    num = int(input())
    for j in fibo[num]:
        print(j, end =' ')
    print()