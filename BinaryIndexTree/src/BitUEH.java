import java.util.Scanner;

public class BitUEH {
    public int bit[],input[];
    public int capacity;
    public BitUEH(int capacity){
        this.capacity=capacity;
        this.bit=new int[capacity+1];
        this.input=new int[capacity+1];
    }
    public double get(int x){
        int s=0;
        while(x>0){
            s+=bit[x];
            x-=x&(-x);
        }
        return s;
    }

    public void update(int idx, int v){
        while (idx<=capacity){
            bit[idx]+=v;
            idx+=(idx&(-idx));
        }
    }
    public void updateRange(int l,int r,int v){
        update(l,v);

    }



}
