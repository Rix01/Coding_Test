# 단어의 수 n
# 단어 길이 2 ~ 10만
# 모든 단어 길이 합 100만 안 넘음

def checkWord(word):
    stack = [word[0]]   # 맨 첫 단어부터 시작
    for j in range(1, len(word)):
        # 비었으면 그냥 스택에 넣어주고 다음으로
        if(len(stack) == 0):
            stack.append(word[j])
            continue

        now = stack[-1]  # 스택으로 치면 맨 위
        if(word[j] == now):
            stack.pop()
        else:
            stack.append(word[j])

    if(len(stack) == 0):
        return True
    else:
        return False

n = int(input())
words = []
for i in range(n):
    words.append(list(input()))
cnt = 0
for word in words:
    if(checkWord(word)):
        cnt += 1
print(cnt)

