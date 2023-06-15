package atcoder.abc301;

import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }

        System.out.print(a[0] + " ");
        for(int i = 0; i < n - 1; i++){
//            System.out.print(a[i] + " ");

            if(a[i + 1] - a[i] > 1){
                for(int j = a[i] + 1; j < a[i + 1] ; j++){
                    System.out.print(j + " ");
                }
            }

            if(a[i] - a[i + 1] > 1){
                for(int j = a[i] - 1; j > a[i + 1] ; j--){
                    System.out.print(j + " ");
                }
            }


            System.out.print(a[i + 1] + " ");
        }
    }
}
