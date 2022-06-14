package vu.htr.cs;

import java.util.Scanner;

public class Gss {
    private final int maxN= (int) 5e4+7;
    private int a[];
    private Node st[];
    public Gss(){
        a=new int[maxN];
        st=new Node[4*maxN];
    }
    public void build(int id,int l,int r){
        if(l==r){
            st[id]=new Node(a[l],a[l],a[l],a[l]);
            return;
        }
        int mid=(l+r)/2;
        build(2*id+1,l,mid);
        build(2*id+2,mid+1,r);
        st[id]=Node.add(st[2*id+1],st[2*id+2]);
    }
    public void inputArr(int capacity){
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<capacity;i++){
            a[i]=sc.nextInt();
        }
    }
    public Node get(int id,int l,int r,int u,int v){
        if(u>r||v<l){
            return new Node();
        }
        if(l>=u&&r<=v){
            return st[id];
        }
        int mid=(l+r)/2;
        return Node.add(get(2*id+1,l,mid,u,v),get(2*id+2,mid+1,r,u,v));
    }

}
