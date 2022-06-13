
class PriorQueue(object):
    def __init__(self,arr=[]):
        self.__arr=arr
        self.__n=len(arr)
        self.heapSort()
        
    def heapify(self,n,i):
        largest=i;
        left=2*i+1
        right=2*i+2
        if(left<n and self.__arr[left]>self.__arr[largest]):
            largest=left
        if(right<n and self.__arr[right]>self.__arr[largest]):
            largest=right
        if(largest!=i):
            self.swap(i,largest)
            self.heapify(n,largest)
    
    def swap(self,a,b):
        temp=self.__arr[a]
        self.__arr[a]=self.__arr[b]
        self.__arr[b]=temp 
    def heapSort(self):
        i=self.__n//2 -1
        while(i>=0):
            self.heapify(self.__n,i)
            i=i-1
        j=self.__n -1
        while(j>=0):
            self.swap(0,j)
            self.heapify(j,0)
            j=j-1
    def __str__(self):
        return self.__arr

    def push(self,element):
        if(self.__n==0):
            self.__arr.append(element)
            self.__n=len(self.__arr)
        else:
            self.__arr.append(element)
            self.__n=len(self.__arr)
            self.heapSort()

    def pop(self): 
        if(self.__n==0):
            print("Prior Queue is Empty!")
            return None
        else:
            self.__n=self.__n -1
            return self.__arr.pop(0)


