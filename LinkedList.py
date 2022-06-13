
class Node:
    def __init__(self,data,next=None):
        self.__data=data
        self.__next=next
    def setNext(self,node):
        self.__next=node
    def getNext(self):
        return self.__next
    def getData(self):
        return self.__data

class LinkedList(object):
    def __init__(self):
        self.__head=None
        self.__tail=None
    def getHead(self):
        return self.__head
    def getTail(self):
        return self.__tail
    def addHead(self,node):
        if(self.__head==None):
            self.__head=node
            self.__tail=node
        else:
            node.setNext(self.__head)
            self.__head=node
    def addTail(self,node):
        if(self.__tail==None):
            self.__tail=node
            self.__head=node
        else:
            self.__tail.setNext(node)
            self.__tail=node

    def addNode(self,node,position):
        if(position==0 or self.__head==None):
            self.addHead(node)
        else:
            k=1
            p=self.__head
            while(k!=position and p!=None):
                p=p.getNext()
                k=k+1
            if(k!=position):
                self.addTail(node)
            else:
                node.setNext(p.getNext())
                p.setNext(node.setNext())
    def rmNodeHead(self):
        if(self.__head==None):
            print("Done")
        else:
            self.__head=self.__head.getNext()
    def rmNodeTail(self):
        if(self.__tail==None):
            print("Done")
        else:
            p=self.__head
            while(p.getNext().getNext()!=None):
                p=p.getNext()

            #p.setNext(None)
            p.setNext(p.getNext().getNext())
    def rmAt(self,position):
        if(position==0 or self.__head==None or self.__head.getNext()==None):
            self.rmNodeHead()
        k=1
        p=self.__head
        while(k!=position and p!=None):
            p=p.getNext()
            k=k+1
        if(k!=position):
            self.rmNodeTail()
        else:
            p.setNext(p.getNext().getNext())
    def get(self,index):
        k=1
        p=self.__head
        while(k!=index and p!=None):
            p=p.getNext()
            k=k+1
        if(k!=index):
            return None
        return p.getData()
    def Search(self,value):
        k=0
        p=self.__head
        if(p==None):
            print("Danh sach rong")
            return None
        if(p.getData==value):
            return k
        k=k+1#k=1
        while(p.getNext()!=None):
            p=p.getNext()
            if(p.getData()==value):
                return k
            k=k+1
        return -1
    def __len__(self):
        p=self.__head
        if(p==None):
            return 0
        else:
            k=0
            while(p.getNext()!=None):
                p=p.getNext()
                k=k+1
        return k
    def getPrevNode(self,ref_node):
        current=self.__head
        while(current and current.getNext()!=ref_node):
            current=current.getNext()
        return current
    def duplicate(self):
        copy=LinkedList()
        current=self.__head
        while(current):
            node = Node(current.data)
            copy.addTail(node)
            current=current.getNext();
    def display(self):
        current=self.__head
        while current:
            print(current.getData,end=' ')
            current=current.getNext()
    def rmNode(self,refNode):
        prevNode=self.getPrevNode()
        if(prevNode == None or refNode.getData()==self.__head.getData()):
            self.__head=self.__head.getNext()
        else:
            prevNode.setNext(refNode.getNext())


    