package atcoder.abc318;

import java.util.HashSet;
import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        HashSet<String> set = new HashSet<String>();

        for(int i = 0; i < n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();

            for(int j = a; j < b; j++) {
                for (int k = c; k < d; k++) {
                    set.add(j + ", " + k);
                }
            }
        }

        System.out.println(set.size());

    }
}
