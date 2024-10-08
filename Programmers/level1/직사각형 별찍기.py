# 문자열의 양쪽 끝에 있는 공백(스페이스, 탭, 줄바꿈 문자 등)을 제거
a, b = map(int, input().strip().split(' '))
row = []
col = []

for i in range(a):
    col.append('*')

for j in range(b):
    row.append(col)
    
# 배열 출력
for i in range(b):
    for j in range(a):
        print(row[i][j], end='')
    print()
    