apt = [[0 for i in range(15)] for i in range(15)]
t = int(input())

# 첫 apt[0]은 숫자 순서대로
apt[0] = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]

# 그 이후부터 채우기
for i in range(1, 15):
    for j in range(1, 15):
        apt[i][j] = sum(apt[i-1][:j+1])

for i in range(t):
    k = int(input())
    n = int(input())
    print(apt[k][n])