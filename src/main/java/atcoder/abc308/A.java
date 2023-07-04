package atcoder.abc308;

import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int a[] = new int[8];

        for(int i = 0; i < 8; i++){
            a[i] = sc.nextInt();
            if(a[i] < 100 || a[i] > 675 || a[i] % 25 != 0){
                System.out.println("No");
                return;
            }
            else if(i > 0 && a[i - 1] > a[i]){
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}
