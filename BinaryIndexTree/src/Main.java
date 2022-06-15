import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("Nhap so luong phan tu cua mang");
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        BitUEH htv= new BitUEH(n);

        System.out.print("Nhap q ");
        int q=sc.nextInt();

        for(int i=1;i<=htv.capacity;i++){
            System.out.println("Nhap phan tu thu " + i);
            htv.input[i]=i;
            htv.update(i,htv.input[i]);
        }
        while(q-->0){
            System.out.print("Nhap type truy van ");
            int t=sc.nextInt();
            if(t==1){
                int x=sc.nextInt();
                int v=sc.nextInt();
                htv.update(x,v-htv.input[x]);
                htv.input[x]=v;
            }
            else{
                int x= sc.nextInt();
                System.out.println(htv.get(x));
            }
        }
    }
}