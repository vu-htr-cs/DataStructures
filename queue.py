
class Queue(object):
    def __init__(self,capacity=3):
        self.__queue=[]
        self.__capacity=capacity
        self.__front=0
        self.__rear=-1
    
    def isEmpty(self):
        if(self.__rear<self.__front):
            return True
        else: 
            return False
    def enqueue(self,element):
        if(self.__rear >= self.__capacity -1):
            print("Queue is Empty")
            return None
        else:
            self.__queue.append(element)
            self.__rear=self.__rear+1
    
    def dequeue(self):
        if(self.isEmpty()):
            print("Queue is empty!")
            return None
        else:
            res=self.__queue[self.__front]
            #self.__front=self.__front+1
            self.__queue.pop(self.__front)  
            self.__rear=self.__rear-1
            return res
    def isFull(self):
        if(self.__rear>=self.__capacity):
            return True
        else:
            return False
