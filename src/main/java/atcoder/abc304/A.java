package atcoder.abc304;

import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String names[] = new String[n];
        int ages[] = new int[n];

        int minAge = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i = 0; i < n; i++){
            names[i] = sc.next();
            ages[i] = sc.nextInt();

            if(ages[i] < minAge){
                minAge = ages[i];
                minIndex = i;
            }
        }

        for(int i = 0; i < n; i++) {
            System.out.println(names[(i + minIndex) % n]);
        }
    }
}
