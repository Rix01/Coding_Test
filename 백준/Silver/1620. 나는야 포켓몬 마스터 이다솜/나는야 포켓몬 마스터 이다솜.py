import sys
input = sys.stdin.readline

m, n = map(int, input().split())
pokemon_num = dict()
pokemon_name = dict()
for i in range(1, m+1):
    pokemon = input().rstrip()
    pokemon_num[i] = pokemon
    pokemon_name[pokemon] = i

for _ in range(n):
    quiz = input().rstrip()
    if(quiz.isalpha()):
        print(pokemon_name[quiz])
    elif(quiz.isdigit()):
        print(pokemon_num[int(quiz)])