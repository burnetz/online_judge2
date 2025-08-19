package atcoder.abc417;

import java.util.LinkedList;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        LinkedList<Integer> list = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            list.addLast(sc.nextInt());
        }

        for(int i = 0; i < m; i++) {
            int x = sc.nextInt();

            list.remove(Integer.valueOf(x));
        }

        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}