package atcoder.abc361;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();

        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        list.add(k, x);

        list.forEach(e -> System.out.print(e + " "));
    }
}