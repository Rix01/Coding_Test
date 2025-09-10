class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        self.prev = None

class LinkedList:
    def __init__(self, data):
        self.head = Node(data)
        self.line = []

    def append(self, data):
        new_node = Node(data)

        cur = self.head
        while cur.next is not None:
            cur = cur.next
        cur.next = new_node
        new_node.prev = cur

    def last_append(self, data):
        cur = self.head
        while cur.next is not None:
            cur = cur.next
        last_node = Node(data)
        cur.next = last_node
        last_node.next = self.head
        last_node.prev = cur
        self.head.prev = last_node

    def delete(self, num, per):
        cur = self.head
        for _ in range(num):
            for _ in range(per-1):
                cur = cur.next
            self.line.append(cur.data)
            prev_node = cur.prev
            next_node = cur.next
            prev_node.next = next_node
            next_node.prev = prev_node
            cur = next_node
        return self.line

n, k = map(int, input().split())

circularList = LinkedList(1)
for i in range(2, n):
    circularList.append(i)

# 마지막은 처음과 이어주기
circularList.last_append(n)

result = circularList.delete(n, k)
print("<" + ", ".join(map(str, result)) + ">")