package vu.htr.cs;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
}
