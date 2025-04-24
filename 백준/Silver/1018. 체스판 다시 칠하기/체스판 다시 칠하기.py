import sys
input = sys.stdin.readline
chessBoard = []

# 순서대로 행, 열
n, m = map(int, input().split())

# 체스보드 입력 받기
for _ in range(n):
    chessBoard.append(list(map(str, input().strip())))

colors = ['W', 'B']

# 8*8 탐색 (흰검흰검)
# 시작 좌표 x,y
def wb88Check(board, x, y):
    cnt = 0
    colorIdx = 0    # 흰색부터 시작.
    for i in range(x, x+8):
        # 행 바뀔 때도 바꿔야 함. 짝수 줄 0, 홀수 줄 1
        colorIdx = i%2
        for j in range(y, y+8):
            if board[i][j] != colors[colorIdx]:
                cnt += 1
            colorIdx = (colorIdx + 1) % 2# 흰이면 검. 검이면 흰.
    return cnt

# 8*8 탐색 (검흰검흰)
# 시작 좌표 x,y
def bw88Check(board, x, y):
    cnt = 0
    colorIdx = 1  # 검은색부터 시작.
    for i in range(x, x+8):
        # 행 바뀔 때도 바꿔야 함. 짝수 줄 1, 홀수 줄 0
        colorIdx = (i+1) % 2
        for j in range(y, y+8):
            if board[i][j] != colors[colorIdx]:
                cnt += 1
            colorIdx = (colorIdx + 1) % 2  # 흰이면 검. 검이면 흰.
    return cnt


answerMin = []   # 작은 값 찾기
for r in range(n-7):
    for c in range(m-7):
        answerMin.append(min(wb88Check(chessBoard, r, c), bw88Check(chessBoard, r, c)))

print(min(answerMin))