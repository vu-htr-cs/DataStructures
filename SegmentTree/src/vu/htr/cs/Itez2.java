package vu.htr.cs;

public class Itez2 {
    private final int maxN= (int) (1e5+7);
    private double st[];
    private int a[]; // item phai <= 10^9 thi int chua gia tri 4 bytes = 32 bit= - 2^31< item < 2^31. Vi the chon int
    public Itez2(){
        st=new double[4*maxN];
        a=new int[maxN];
    }
    public void update(int id,int l,int r,int i,int val){
        if(l>i||r<i){
            return;
        }
        if(l==r){
            st[id]=val;
            return;
        }
        int mid=(l+r)/2;
        update(2*id+1,l,mid,i,val);
        update(2*id+2,mid+1,r,i,val);
        st[id]=st[2*id+1]+st[2*id+2];
    }
    public double get(int id,int l,int r,int u,int v){
        if(l>v||r<u){
            return 0;
        }
        if(l>=u||r<=v){
            return st[id];
        }
        int mid=(l+r)/2;
        return get(2*id+1,l,mid,u,v) + get(2*id+2,mid+1,r,u,v);
    }
}
