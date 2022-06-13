
class HashTable:
    def __init__(self,size):
        self.size=size
        self.hash_table=self.createBuckets()

    def createBuckets(self):
        return [[] for _ in range(self.size)]
    def insert(self,key,val):
        hash_key=hash(key)%self.size
        bucket=self.hash_table[hash_key]
        found_key=False

        for index,record in enumerate(bucket):
            record_key,record_val=record
            if(record_key==key):
                found_key=True
                break
        if found_key:
            bucket[index]=(key,val)
        else:
            bucket.append((key,val))
    
    def get(self,key):
        hash_key=hash(key)%self.size
        bucket=self.hash_table[hash_key]
        found_key=False

        for index,record in enumerate(bucket):
            record_key,record_val=record
            if record_key==key:
                found_key=True
                break
        if found_key:
            return record_val
        else:
            return "No record found"

    def rm_val(self,key):
        hash_key=hash(key)%self.size
        bucket=self.hash_table[hash_key]
        found_key=False

        for index,record in enumerate(bucket):
            record_key,record_val=record
            if record_key==key:
                found_key=True
                break
        if found_key:
            bucket.pop(index)
            return None
        else:
            print("No key match dictionary")
            return None

    def __str__(self):
        return "".join(str(item) for item in self.hash_table)
