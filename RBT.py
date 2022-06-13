from logging import RootLogger
from re import X
from turtle import left, right


class Node():
    def __init__(self,data):
        self.data=data
        self.left=None
        self.right=None
        self.parent=None
        self.color=1

class RedBlackTree():
    def __init__(self):
        self.TNULL=Node(0)
        self.TNULL.color=0
        self.TNULL.right=None
        self.TNULL.left=None
        self.TNULL.parent=None
        self.root=self.TNULL
    
    def insert(self,key):
        if(self.root==None):
            self.root=Node(0)
            self.root.color=0
        else:
            node=Node(key)
            node.parent=None
            node.data=key
            node.left=self.TNULL
            node.right=self.TNULL
            node.color=1

            y=None
            x=self.root
            while x!=self.TNULL:
                y=x
                if node.data< x.data:
                    x=x.left
                else :
                    x=x.right

            node.parent=y
            if y==None:
                self.root=node
            elif node.data< y.data:
                y.left=node
            else:
                y.right=node
            
            if node.parent==None:
                node.color=0
                return
            if node.parent.parent==None:
                return

            self.fix_insert(node)
    def fix_insert(self,k):
        while k.parent.color==1:
            if k.parent==k.parent.parent.right:
                u=k.parent.parent.left
                if u.color==1:
                    u.color=0
                    k.parent.color=0
                    k.parent.parent.color=1
                    k=k.parent.parent
                else:#TH P
                    if k==k.parent.left:
                        self.right_rotate(k.parent)#PT
                    self.left_rotate(k.parent.parent)#PP
                    k.parent.color = 0
                    k.parent.parent.color = 1
                   
            else:
                u=k.parent.parent.right
                if u.color==1:
                    u.color=0
                    k.parent.color=0
                    k.parent.parent.color=1
                    k=k.parent.parent
                else:
                    if k==k.parent.right:
                        self.left_rotate(k.parent)
                    self.right_rotate(k.parent.parent)
                    k.parent.color = 0
                    k.parent.parent.color = 1
                    
            if k==self.root:
                break
        self.root.color=0
    def delete_fix(self,x):
        while x!=self.root and x.color==0:
            if x==x.parent.left:
                s=x.parent.right
                if s.color==1:
                    s.color=0
                    x.parent.color=1
                    self.left_rotate(x.parent)
                    s=x.parent.right
                if s.left.color==0 and s.right.color==0:
                    s.color=1
                    x=x.parent
                else:
                    if s.right.color==0:
                        s.left.color=0
                        s.color=1
                        self.right_rotate(s)
                        s=x.parent.right

                    s.color = x.parent.color
                    x.parent.color = 0
                    s.right.color = 0
                    self.left_rotate(x.parent)
                    x = self.root
            else:
                s = x.parent.left
                if s.color == 1:
                    s.color = 0
                    x.parent.color = 1
                    self.right_rotate(x.parent)
                    s = x.parent.left

                if s.right.color == 0 and s.right.color == 0:
                    s.color = 1
                    x = x.parent
                else:
                    if s.left.color == 0:
                        s.right.color = 0
                        s.color = 1
                        self.left_rotate(s)
                        s = x.parent.left

                    s.color = x.parent.color
                    x.parent.color = 0
                    s.left.color = 0
                    self.right_rotate(x.parent)
                    x = self.root
        x.color = 0


    def right_rotate(self,root):
        x=root.left
        root.left=x.right
        if(x.right!=None):
            x.right.parent=root

        x.parent=root.parent
        if root.parent==None:
            self.root=x 
        elif root==root.parent.left:
            root.parent.left=x 
        else :
            root.parent.right=x 
        x.right=root
        root.parent=x 
        return x 
    def left_rotate(self,root):
        y=root.right
        root.right=y.left
        if(y.left!=None):
            y.left.parent=root
        y.parent=root.parent
        if root.parent==None:
            self.root=y
        elif root==root.parent.left:
            root.parent.left=y
        else:
            root.parent.right=y

        y.left=root
        root.parent=y
 
        return y

     # Preorder
    def pre_order_helper(self, node):
        if node != self.TNULL:
            self.pre_order_helper(node.left)
            self.pre_order_helper(node.right)

    def preorder(self):
        self.pre_order_helper(self.root)

    def delete_node_helper(self, node, key):
        z = self.TNULL
        while node != self.TNULL:
            if node.item == key:
                z = node

            if node.item <= key:
                node = node.right
            else:
                node = node.left

        if z == self.TNULL:
            print("Cannot find key in the tree")
            return

        y = z
        y_original_color = y.color
        if z.left == self.TNULL:
            x = z.right
            self.__rb_transplant(z, z.right)
        elif (z.right == self.TNULL):
            x = z.left
            self.__rb_transplant(z, z.left)
        else:
            y = self.minimum(z.right)
            y_original_color = y.color
            x = y.right
            if y.parent == z:
                x.parent = y
            else:
                self.__rb_transplant(y, y.right)
                y.right = z.right
                y.right.parent = y

            self.__rb_transplant(z, y)
            y.left = z.left
            y.left.parent = y
            y.color = z.color
        if y_original_color == 0:
            self.delete_fix(x)

