package atcoder.abc340;

import java.util.Scanner;
import java.util.Vector;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        Vector<Integer> vec = new Vector<>();

        for (int i = 0; i < q; i++) {
            int mode = sc.nextInt();

            switch (mode) {
                case (1) -> {
                    vec.add(sc.nextInt());
                }
                case (2) -> {
                    System.out.println(vec.get(vec.size() - sc.nextInt()));
                }
            }
        }
    }
}
