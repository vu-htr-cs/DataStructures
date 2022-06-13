class Node:
    def __init__(self,data,left=None,right=None):
        self.data=data
        self.left=left
        self.right=right
        self.height=1

class AVL(object):  
    def getHeight(self,root):
        if(root==None):
            return 0
        return 1 + max(self.getHeight(root.left),self.getHeight(root.right))

    def rightRotate(self,root):
        x=root.left
        root.left=x.right
        root.height=1 + max(self.getHeight(root.left),self.getHeight(root.right))

        x.height=1+max(self.getHeight(x.left),self.getHeight(x.right))

        return x
    def leftRotate(self,root):
        y=root.right
        root.right=y.left

        root.height=1+max(self.getHeight(root.left),self.getHeight(root.right))
        y.height=1+max(self.getHeight(y.left),self.getHeight(y.right))

        return y
    def insert(self,root,value):
        if(root is None):
            return Node(value)

        elif value<root.data:
            root.left=self.insert(root.left,value)
        else:
            root.right=self.insert(root.right,value)


        root.height=1+max(self.getHeight(root.left),self.getHeight(root.right))
        valBalance=self.getBalance(root)
        if(valBalance>1 and value<root.left.data):
                return self.rightRotate(root)
        if(valBalance >1 and valBalance > value.left.data):
            root.left=self.leftRotate(root.left)
            return self.rightRotate(root)

        if(valBalance < -1):
            if(value>root.right.data):
                return self.leftRotate(root)

            else:
                root.right=self.rightRotate(root.right)
                return self.rightRotate(root)

        return root

    def getBalance(self,root):
        return self.getHeight(root.left)-self.getHeight(root.right)

    def rmNode(self,root,value):
        if not root:
            return root
        elif value<root.data:
            root.left=self.rmNode(root.left,value)
        elif value > root.data:
            root.right=self.rmNode(root.right,value)
        else:
            if root.left is None:
                temp=root.right
                root=None
                return temp
            elif root.right is None:
                temp=root.left
                root=None
                return temp
            temp=self.getMinValueNode(root.right)
            root.data=temp.data
            root.right=self.rmNode(root.right,temp.data)
        if root is None:
            return root

        root.height=1+ max(self.getHeight(root.left),self.getHeight(root.right))
        balanceFactor=self.getBalance(root)
        if balanceFactor > 1:
            if self.getBalance(root.left) >= 0:
                return self.rightRotate(root)
            else:
                root.left = self.leftRotate(root.left)
                return self.rightRotate(root)
        if balanceFactor < -1:
            if self.getBalance(root.right) <= 0:
                return self.leftRotate(root)
            else:
                root.right = self.rightRotate(root.right)
                return self.leftRotate(root)
        return root

    def getMinValueNode(self,root):
        if root is None or root.left is None:
            return root
        return self.getMinValueNode(root.left)