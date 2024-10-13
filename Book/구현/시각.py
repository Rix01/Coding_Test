n = int(input())

h = n

cnt = 0
for i in range(0, h+1):
    if(i==3 or i== 13 or i==23):
        cnt += 60 * 60
    else:
        # 분에 3이 들어가는 경우 15가지 * 60초
        cnt += 15*60
        # 초에 3이 들어가는 경우 45분 * 15가지
        cnt += 45*15

print(cnt)