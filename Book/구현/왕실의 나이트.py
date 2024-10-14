dx = [-1,-1,1,1,-2,-2,2,2]
dy = [-2,2,-2,2,-1,1,-1,1]

# str로 받음
pos = input()
# ord 함수를 이용해서 알파벳을 숫자로.
x = ord(pos[0]) - ord('a') + 1
y = int(pos[1])

cnt = 0
# 8번의 경우의 수
for i in range(8):
    mx = x + dx[i]
    my = y + dy[i]
    if(mx>=1 and mx <=8 and my >=1 and my <= 8 ):
        cnt += 1

print(cnt)