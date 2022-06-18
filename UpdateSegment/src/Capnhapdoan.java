public class Capnhapdoan {
    public int n;
    public int bit1[],bit2[];
    public int input[];
    public Capnhapdoan(int n){
        this.n=n;
        //index cua mang bat dau tu 1
        bit1= new int[n+1];
        bit2=new int[n+1];
        input=new int[n+1];

    }
    public void updatePoint(int arr[],int idx,int v){
        while(idx<=n){
            arr[idx]+=v;
            idx=(idx&(-idx));
        }
        //Nhap tung phan tu vao mang, sau do hay dung updatepoint cho moi vong lap
    }

    public void updateRange(int l,int r,int v){
        updatePoint(bit2,l,v);
        updatePoint(bit2,r+1,-v);
        updatePoint(bit1,l,(n-l+1)*v);
        updatePoint(bit2,r+1,-(n-r)*v); // -(n-(r+1)+1)*v
    }
    private double getSumOnBit(int arr[],int idx){
        double s=0;
        while(idx>0){
            s=s +arr[idx];
            idx-=(idx&(-idx));

        }
        return s;
    }
    public double prefixSum(int u){
        return getSumOnBit(bit1,u)-getSumOnBit(bit2,u)*(n-u);
    }
    public double rangeSum(int l,int r){
        return prefixSum(r) - prefixSum(l-1);
        //   [              51] r
        // [         31]
        // range 31 - 51 ?  [51] =[0-31]+ [32-51] = [0-30] + [31-51]  --> [31-51] = [0-51] - [0-30] (l-1)
    }

}

