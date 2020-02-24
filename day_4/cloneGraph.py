"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = []):
        self.val = val
        self.neighbors = neighbors
"""
# dfs
class Solution:
    visited = {}
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return node
        if node in self.visited:
            return self.visited[node]
        new_node = Node(node.val)
        self.visited[node] = new_node
        new_node.neighbors = [self.cloneGraph(n) for n in node.neighbors]
        return new_node

# bfs

class Solution:
    visited = {}
    def cloneGraph(self, node: 'Node') -> 'Node':
        queue = []
        queue.append(node)
        head = None
        queue_index = 0
        while(queue_index>=len(queue)):
            node = queue[queue_index]
            if node in visited:
                return visited[node]
            new_node = Node(node.val,[])
            if not head:
                head = new_node
            for n in node.neighbors:
                queue.append(n)
            queue_index = queue_index + 1
        return head

