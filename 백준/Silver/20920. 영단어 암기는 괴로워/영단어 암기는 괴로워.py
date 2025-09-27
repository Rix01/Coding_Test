n, m = map(int, input().split())
words = dict()

for _ in range(n):
    word = input()
    # m글자 이상인 것들만
    if(len(word)>=m):
        if(word not in words):
            words[word] = [1, len(word)]
        else:
            words[word][0] += 1

sorted_words = sorted(words.items(), key=lambda item: (-item[1][0], -item[1][1], item[0]))

for word in sorted_words:
    print(word[0])
