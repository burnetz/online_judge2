package atcoder.abc359;

import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(sc.next().equals("Takahashi")) {
                count++;
            }
        }

        System.out.println(count);
    }
}