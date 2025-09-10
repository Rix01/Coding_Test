n = int(input())
schedule = []
for _ in range(n):
    t, p = map(int, input().split())
    schedule.append((t,p))

day_money = [0] * (n+2)

for i in range(n):
    day, money = schedule[i]

    # 상담 안 함
    day_money[i+1] = max(day_money[i+1], day_money[i])

    # 상담 함
    end_day = i + day
    if(end_day <= n+1):
        day_money[end_day] = max(day_money[end_day], day_money[i] + money)

print(day_money[n])