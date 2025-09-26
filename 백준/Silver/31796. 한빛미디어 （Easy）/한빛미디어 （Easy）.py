'''
- 한 페이지에 책을 한 종류 이상 진열
- 2배 이상 차이 나는 책을 한 페이지에 진열 불가능

진열될 페이지 수 최소화

오름차순 정렬 이후에 맨 처음에 들어간 애 기억했다가 2배 이하면 계속 페이지에 넣으면 되겠는데
'''

n = int(input())
books = []
books = list(map(int, input().split()))

def book_sort(n, books):
    bookshelf = dict()

    # 오름차순 정렬
    books.sort()

    page = 1
    # 첫 책 기록
    now = books[0]
    bookshelf[page] = [now]

    for i in range(1, len(books)):
        if(books[i] < (now*2)):
            bookshelf[page].append(books[i])


        else:
            now = books[i]
            page+=1
            bookshelf[page] = [now]

    print(len(bookshelf))

book_sort(n, books)
