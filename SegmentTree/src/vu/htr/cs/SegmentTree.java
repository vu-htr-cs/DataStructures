package vu.htr.cs;

public class SegmentTree {
    private int arr[];
    private int sgt[];
    public SegmentTree(int capacity){
        arr=new int[capacity];
        sgt=new int[4*capacity];
    }
    public void build(int id,int l,int r){
        if(l==r){
            sgt[id]=arr[l];
            return;
        }
        int mid=(l+r)/2;
        build(2*id+1,l,mid);
        build(2*id+2,mid+1,r);
        sgt[id]=Math.max(sgt[2*id+1],sgt[2*id+2]);
    }
    public void update(int id,int l,int r,int u,int v,int val){
        if(u>r||v<l){
            return;
        }
        if(l==r){
            sgt[id]=val;
            return;
        }
        int mid=(l+r)/2;
        update(2*id+1,l,mid,u,v,val);
        update(2*id+2,mid+1,r,u,v,val);
        sgt[id]=Math.max(sgt[2*id+1],sgt[2*id+2]);

    }
    public int get(int id,int l,int r,int u,int v){
        if(u>r||v<l){
            return Integer.MIN_VALUE;
        }
        if(l==r){
            return sgt[id];
        }
        int mid=(l+r)/2;
        return Math.max(get(2*id+1,l,mid,u,v),get(2*id+2,mid+1,r,u,v));
    }

}
