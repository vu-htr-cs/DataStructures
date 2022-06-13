from queue import Queue
from stack import Stack
from PriorQueue import PriorQueue
from BST import BinarySearchTree
if __name__=="__main__":
   tree=BinarySearchTree(110)
   tree.insert(50);
   tree.insert(30);
   tree.insert(20);
   tree.insert(40);
   tree.insert(70);
   tree.insert(60);
   tree.insert(80);
 
   #print inorder traversal of the BST
   tree.inorder();


