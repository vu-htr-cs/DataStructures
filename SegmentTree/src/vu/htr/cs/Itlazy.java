package vu.htr.cs;

public class Itlazy {
    private final int inf= (int)1e9+7;
    private final int maxN= (int) 1e5+7;
    public int a[];
    private double st[],lazy[];

    public Itlazy(){
        a=new int[maxN];
        st=new double[4*maxN];
        lazy=new double[4*maxN];
    }
    public void build(int id,int l,int r){
        if(l==r){
            st[id]=a[l];
            return;
        }
        int mid=(l+r)/2;
        build(2*id+1,l,mid);
        build(2*id+2,mid+1,r);
        st[id]=Math.max(st[2*id+1],st[2*id+2]);

    }
    public void fix(int id,int l,int r){
        if(lazy[id]==0) return;
        st[id]+=lazy[id];
        if(l!=r){
            lazy[2*id+1]+=lazy[id];
            lazy[2*id+2]+=lazy[id];
        }
        lazy[id]=0;
    }
    public void update(int id,int l,int r,int u,int v,int val){
        fix(id, l, r);
        if(l>v||r<u) return;
        if(l>=u&&r<=v){
            lazy[id]+=val;
            fix(id,l,r);
            return;
        }
        int mid=(l+r)/2;
        update(2*id+1,l,mid,u,v,val);
        update(2*id+2,mid+1,r,u,v,val);

        st[id]=Math.max(st[2*id+1],st[2*id+2]);
    }
    public double get(int id,int l,int r,int u,int v){
        fix(id, l, r);
        if(l>v||r<u) return -inf;
        if(l>=u&&r<=v) return st[id];
        int mid=(l+r)/2;
        return Math.max(get(2*id+1,l,mid,u,v),get(2*id+2,mid+1,r,u,v));

    }

}
