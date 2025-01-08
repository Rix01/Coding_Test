# 입력1
n, m = map(int, input().split())
# 입력2
x, y, direction = map(int, input().split())
# 입력3
gameMap = []
for i in range(n):
    gameMap.append(list(map(int, input().split())))

# 방문 표시 Map
visitMap = [[0]*m for _ in range(n)]
visitMap[x][y] = 1  # 맨 처음 위치 방문 표시

# 북, 동, 남, 서 (0 1 2 3)
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

# 결과 count
count = 1   # 맨 처음 위치도 포함되니까

# 왼쪽으로 도는 함수
def turn_left():
    global direction
    direction -= 1
    if(direction == -1):
        direction = 3

# 다 가본 곳인지 확인하기 위한 turn_flag
turn_flag = 0

# 게임 시작
while(True):
    turn_left()
    nx = x + dx[direction]
    ny = y + dy[direction]
    
    # 아직 안 가본 곳이면 전진
    if(visitMap[nx][ny] == 0 and gameMap[nx][ny] == 0):
        visitMap[nx][ny] = 1
        count += 1
        x = nx
        y = ny
        turn_flag = 0

    # 가본 곳이면 돌기. 단, 4방향 다 돌아봤으면 뒤로 가야됨
    else:
        turn_flag += 1

    if(turn_flag == 4):
        nx = x - dx[direction]
        ny = y - dy[direction]
        if(gameMap[nx][ny]==0):
            x = nx
            y = ny
            turn_flag = 0
        # 뒤로 못 가면 끝냄
        else:
            break

print(f"이동 횟수 : {count}")
