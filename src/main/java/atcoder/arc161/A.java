package atcoder.arc161;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }

        Arrays.sort(a);

        for(int i = 0; i < n / 2; i++){
            int tmp = i + n / 2 + 1;

            if(a[tmp] == a[i] || a[tmp] == a[i + 1]){
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}
