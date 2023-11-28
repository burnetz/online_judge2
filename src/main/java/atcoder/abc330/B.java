package atcoder.abc330;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        for(int i = 0; i < n; i++) {
            if(a[i] <= l){
                System.out.print(l + " ");
            }
            else if(a[i] >= r){
                System.out.print(r + " ");
            }
            else {
                System.out.print(a[i] + " ");
            }
        }
    }
}
