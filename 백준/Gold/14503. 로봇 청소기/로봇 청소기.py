from collections import deque

n, m = map(int, input().split())
r, c, d = map(int, input().split())

room = []
for i in range(n):
    room.append(list(map(int, input().split())))

# 북 동 남 서
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

# 반시계 방향 회전
def turn_left(d):
    return (d+3) % 4

# 후진
def go_back(d):
    return (d+2) % 4

def clean_robot(r, c, d, room):
    n = len(room)
    m = len(room[0])
    queue = deque([(r, c, d)])

    clean_block_count = 1  # 맨 처음 놓이는 곳 청소
    room[r][c] = 2  # 청소 표시 ( 맨 처음 로봇 청소기가 놓이는 칸 )

    while queue:
        x, y, dir = queue.popleft()
        temp_dir = dir
        for i in range(4):
            # 90도 회전하면서 청소할 칸 찾기
            temp_dir = turn_left(temp_dir)
            nx, ny = x + dx[temp_dir], y + dy[temp_dir]
            if 0 <= nx < n and 0 <= ny < m and room[nx][ny] == 0:
                clean_block_count += 1
                room[nx][ny] = 2 # 청소 완료 표시
                queue.append((nx, ny, temp_dir))
                # while문으로 다시 돌아가야 함
                break
            # 4번 다 돌았는데도 갈 곳 없으면 후진 or 중단
            if i==3:
                temp_dir = go_back(dir)
                nx, ny = x + dx[temp_dir], y + dy[temp_dir]
                if room[nx][ny] == 1:   # 벽이라면 중단
                    return clean_block_count
                queue.append((nx, ny, dir)) # 방향 유지한 채 후진

print(clean_robot(r, c, d, room))