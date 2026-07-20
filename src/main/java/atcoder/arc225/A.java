package atcoder.arc225;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //結論としては(1,2,3,4)を(2,4,1,3)に対応させればOK
        //写像自体は4!=24通りあるが、隣り合う数字が連番になるものはアウトなのでその時点でかなり絞れる。
        int a[] = {0, 2, 4, 1, 3};
        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int tmp = sc.nextInt();

                System.out.print(a[tmp] + " ");
            }
            System.out.println();
        }

    }
}