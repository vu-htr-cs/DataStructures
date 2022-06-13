class Node(object):
    def __init__(self,data,left=None,right=None):
        self.data=data
        self.left=left
        self.right=right

class BinarySearchTree:
    def __init__(self,data=None):
        self.root=Node(data)
    def insert(self,data):
        self.root=self.insertRec(self.root,data)
    def insertRec(self,root,data):
        if(root==None):
            root=Node(data)
            return root
        if(data < root.data):
            root.left= self.insertRec(root.left,data)
        elif data>root.data:
            root.right=self.insertRec(root.right,data)

        return root
    def inorder(self):
        self.inorderRec(self.root)
    def inorderRec(self,root):
        if(root!=None):
            self.inorderRec(root.left)
            print(root.data)
            self.inorderRec(root.right)
    
    


