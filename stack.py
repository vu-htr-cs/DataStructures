class Stack:
    def __init__(self,maxlength):
        self.stack=[]
        self.__maxlength=maxlength
    def push(self,x):
        self.stack.append(x)
    def pop(self):
        if(len(self.stack)==0):
            print("Stack is empty!")
            return None
        return self.stack.pop()
    def __len__(self):
        return len(self.stack)
    def isEmpty(self):
        if(len(self.stack)==0):
            return True
        else:
            return False
    def top(self):
        if(len(self.stack)==0):
            print("Stack is empty!")
            return None
        else:
            return self.stack[-1]
    def __str__(self):
        return "Day la Stack {} co do dai max length la {}".format(self.stack,self.__maxlength)


