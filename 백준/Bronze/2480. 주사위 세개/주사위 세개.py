a, b, c = map(int, input().split())

dice = [0]*7

dice[a] += 1
dice[b] += 1
dice[c] += 1

max_cnt = max(dice)
max_dice_idx = dice.index(max_cnt)

prize = 0
if(max_cnt==3):
    prize = 10000+max_dice_idx*1000
elif(max_cnt==2):
    prize = 1000+max_dice_idx*100
else:
    prize = max(a,b,c)*100

print(prize)