package atcoder.abc415;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        Vector<Integer> vec = new Vector<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '#') {
                vec.add(i + 1);
            }
        }

        for(int i = 0; i < vec.size(); i += 2) {
            int x1 = vec.get(i);
            int x2 = vec.get(i + 1);

            System.out.println(x1 + "," + x2);
        }
    }
}