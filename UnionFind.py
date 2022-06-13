from LinkedList import LinkedList,Node
class UnionFind:
    def __init__(self):
        pass
    def rmDup(lList):
        current1=lList.getHead()
        while(current1):
            current2=current1.getNext()
            data=current1.getData()
            while(current2):
                temp=current2
                current2=current2.getNext()
                if(temp.data==data):
                    lList.rmNode(temp)
            current1=current1.getNext()
    def findUnion(self,list1,list2):
        if(list1.getHead()==None):
            union=list2.duplicate()
            self.rmDup(union)
            return union
        if(list2.getHead()==None):
            union=list1.duplicate()
            self.rmDup(union)
            return union
        
       
        union=list1.duplicate()
        last_node=union.getHead()
        while(last_node.getNext() is not None):
            last_node=last_node.getNext()
        list2_cp=list2.duplicate()
        last_node.setNext(list2_cp.getHead())
        self.rmDup(union)
        return union
             

    def find_intersection(self,llist1, llist2):
        if (llist1.head is None or llist2.head is None):
            return LinkedList()
    
        intersection = LinkedList()
        current1 = llist1.head
        while current1:
            current2 = llist2.head
            data = current1.data
            while current2:
                if current2.data == data:
                    node = Node(data)
                    intersection.insert_at_end(node)
                    break
                current2 = current2.next
            current1 = current1.next
        self.rmDup(intersection)
    
        return intersection





