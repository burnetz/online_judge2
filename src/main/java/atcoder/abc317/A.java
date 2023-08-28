package atcoder.abc317;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();
        int x = sc.nextInt();

        for(int i = 0; i < n; i++){
            int tmp = sc.nextInt();

            if(tmp + h >= x) {
                System.out.println(i + 1);
                return;
            }
        }
    }
}
