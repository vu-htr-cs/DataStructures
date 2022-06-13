
class Node:
    def __init__(self, freq, symbol, left=None, right=None):
        # frequency of symbol
        self.freq = freq
 
        # symbol name (character)
        self.symbol = symbol
 
        # node left of current node
        self.left = left
 
        # node right of current node
        self.right = right
 
        # tree direction (0/1)
        self.huff =''
 
def printNode(node,val=''):
    newVal=val + str(node.huff)
    if(node.left):
        printNode(node.left,newVal)
    if(node.right):
        printNode(node.right,newVal)
    if(not node.left and not node.right ):
        print(newVal)
        print(f"{node.symbol} -> {newVal}")


chars = ['a', 'b', 'c', 'd', 'e', 'f']
 
freq = [ 5, 9, 12, 13, 16, 45]
 
nodes = []

for x in range(len(chars)):
    nodes.append(Node(freq[x],chars[x]))
while(len(nodes)>1):
    nodes=sorted(nodes,key=lambda x:x.freq)
        
    left=nodes[0]
    right=nodes[1]
    left.huff=0
    right.huff=1    
    newNode=Node(left.freq+right.freq,left.symbol+right.symbol,left,right)
    nodes.remove(left)
    nodes.remove(right)
    nodes.append(newNode)
printNode(nodes[0])

