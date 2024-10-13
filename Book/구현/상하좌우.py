n = int(input())
plan = list(input().split())
row, column = 1, 1

for p in plan:
    if(p=="L"):
        if(column - 1 == 0):
            column -= 0
        else:
            column -=1

    elif(p=="R"):
        if(column + 1 ==n+1):
            column += 0
        else:
            column+=1

    elif(p=="U"):
        if(row - 1 == 0):
            row -= 0
        else:
            row -= 1

    elif(p=="D"):
        if(row +1 == n+1):
            row += 0
        else:
            row += 1

print(f"{row} {column}")