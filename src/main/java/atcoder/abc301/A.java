package atcoder.abc301;

import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next();

        char fin = 0;
        int takahashi = 0;
        int aoki = 0;
        for(int i = 0; i < n; i++){
            fin = str.charAt(i);

            if(fin == 'T'){
                takahashi++;
            }
            else {
                aoki++;
            }
        }

        if(takahashi == aoki){
            System.out.println(fin == 'T' ? 'A' : 'T');
        }
        else if(takahashi > aoki){
            System.out.println("T");
        }
        else {
            System.out.println("A");
        }
    }
}
