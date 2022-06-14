package vu.htr.cs;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Main.itez2();
        //Main.gss();
    }
    public static void itez2(){
        System.out.println("Hello world!");
        Scanner scanner= new Scanner(System.in);
        int n=scanner.nextInt();
        int q=scanner.nextInt();
        Itez2 sln=new Itez2();
        while(q>0){
            System.out.print("Nhap type, x,y " );
            int type=scanner.nextInt();
            int x=scanner.nextInt();
            int y=scanner.nextInt();
            if(type==1){
                sln.update(0,0,n-1,x,y);
            }
            else
            {
                System.out.println(sln.get(0,0,n-1,x,y));
            }
            q--;
        }
    }
    public static void gss(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhap n");
        int n=scanner.nextInt();
        Gss gs=new Gss();

        System.out.println("Nhap vao mang a");
        gs.inputArr(n);

        gs.build(0,0,n-1);

        System.out.println("Nhap m");
        int m= scanner.nextInt();
        while(m>0){
            int x=scanner.nextInt();
            int y=scanner.nextInt();
            System.out.println(gs.get(0,0,n-1,x,y).maxsum);
            m--;
        }
    }
    public static void itlazy(){
        Scanner sc= new Scanner(System.in);
        System.out.print("Nhap n");
        int n=sc.nextInt();
        Itlazy it= new Itlazy();
        for(int i=0;i<n;i++){
            it.a[i]=sc.nextInt();
        }
        it.build(0,0,n-1);
        System.out.print("Nhap q");
        int q=sc.nextInt();
        while(q-- >0){
            int type= sc.nextInt();
            int l= sc.nextInt();
            int r=sc.nextInt();

            if(type==1){
                System.out.println("Nhap val");
                int val=sc.nextInt();
                it.update(0,0,n-1,l,r,val);
            }
            else
                System.out.println(it.get(0,0,n-1,l,r));
        }
    }
}
