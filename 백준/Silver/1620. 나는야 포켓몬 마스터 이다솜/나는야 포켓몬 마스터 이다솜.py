import sys

n, m = map(int, sys.stdin.readline().split())
pokeName = {}
pokeNum = {}

for idx in range(1, n+1):
    pokemon = sys.stdin.readline().rstrip()
    pokeNum[idx] = pokemon
    pokeName[pokemon] = idx

for q in range(m):
    quiz = sys.stdin.readline().rstrip()
    # 알파벳이라면 번호 출력
    if(quiz.isalpha()):
        sys.stdout.write(str(pokeName[quiz])+"\n")
    else:
        sys.stdout.write(pokeNum[int(quiz)]+"\n")