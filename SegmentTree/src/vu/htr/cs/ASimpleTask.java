package vu.htr.cs;

public class ASimpleTask {
    private final int maxN=(int)1e5+7;
    private String s;
    public int cnt[];
    private int st[][],lazy[][];

    public ASimpleTask(String s){
        this.s=s;
        cnt=new int[30];
        st=new int[30][4*maxN];
        lazy=new int[30][4*maxN];
    }
    public void build(int id,int l,int r){
        //Tong so ki tu 'a','b',.. tren segment
        for(int ch=0;ch<25;ch++) lazy[ch][id]=-1;
        if(l==r){
            st[s.charAt(l) -'a'][id]=1;
            return;
        }
        int mid=(l+r)/2;
        build(2*id+1,l,mid);
        build(2*id+2,mid+1,r);
        //Tong ki tu rieng le segment parent = tong ki tu rieng le segment a + b
        for(int ch=0;ch<=25;ch++){
            st[ch][id]=st[ch][2*id+1]+st[ch][2*id+2];
        }

    }
    public void fix(int id,int l,int r,int ch){
        if(lazy[ch][id]==-1) return ;
        st[ch][id]=lazy[ch][id]*(r-l+1);
        if (l != r){

        /* Vì là thao tác gán giá trị chứ KHÔNG phải là tăng thêm một lượng
        nên lazy của nút con sẽ gán bằng lazy của nút cha */
            lazy[ch][2 * id] = lazy[ch][id];
            lazy[ch][2 * id + 1] = lazy[ch][id];
        }
        lazy[ch][id] = -1;

    }
    public void update(int id,int l,int r,int u,int v,int val, int ch){
        if(u>r||v<l) return;
        if(u<=l&&r<=v) {
            lazy[ch][id]=val;
            fix(id,l,r,ch);
            return;
        }
        int mid=(l+r)/2;
        update(2*id+1,l,mid,u,v,val,ch);
        update(2*id+2,mid+1,r,u,v,val,ch);
        st[ch][id] = st[ch][2 * id+2] + st[ch][2 * id + 1];
    }
    public int get(int id,int l,int r,int u,int v,int ch){
        fix(id,l,r,ch);
        if(u>r||v<l) return 0;
        if(u<=l&&r<=v){
            return st[ch][id];
        }
        int mid=(l+r)/2;
        return get(2*id+1,l,mid,u,v,ch)+get(2*id+2,mid+1,r,u,v,ch);
    }


}
