package atcoder.abc333;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String edge1 = sc.next();
        String edge2 = sc.next();

        String edgesLen1[] = {"AB", "BC", "CD", "DE", "EA", "AE", "ED", "DC", "CB", "BA"};

        int len1 = 2;
        int len2 = 2;
        for(int i = 0; i < 10; i++) {
            if(edge1.equals(edgesLen1[i])) {
                len1 = 1;
            }
            if(edge2.equals(edgesLen1[i])) {
                len2 = 1;
            }
        }

        if(len1 == len2) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}
