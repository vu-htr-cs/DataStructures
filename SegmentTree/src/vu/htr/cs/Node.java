package vu.htr.cs;

public class Node {
    private final int inf = (int) 1e9 + 7;
    public int pre;
    public int suf, sum, maxsum;

    public Node() {
        this.pre=-inf;
        this.suf=-inf;
        this.sum=0;
        this.maxsum=-inf;
    }
    public Node(int pre,int suf,int sum,int maxsum){
        this.pre=pre;
        this.suf=suf;
        this.sum=sum;
        this.maxsum=maxsum;
    }
    public static Node add(Node a,Node b){
        Node res = new Node();
        res.pre = Math.max(a.pre, b.pre + a.sum);
        res.suf = Math.max(b.suf, a.suf + b.sum);
        res.sum = a.sum + b.sum;
        res.maxsum = Math.max(a.maxsum, b.maxsum);
        res.maxsum = Math.max(res.maxsum, a.suf + b.pre);
        return res;
    }

}
