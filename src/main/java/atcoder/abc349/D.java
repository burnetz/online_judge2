package atcoder.abc349;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        long l = sc.nextLong();
        long r = sc.nextLong();

        Vector<Node> vec = new Vector<>();
        long count = 0;

        //はみ出さない程度にできるだけ大きいべき乗を使って分け続けるのが最適。
loop:        while(l < r) {
            //1Lと書かないとintの範囲でしかシフトできないので注意。
            long pow = 1L << 60;
            while(pow > 0) {

                if (l % pow == 0) {
                    long rem = l / pow;

                    if (pow * (rem + 1) <= r) {
                        count++;
                        vec.add(new Node(l, pow * (rem + 1)));
                        l = (pow * (rem + 1));
                        continue loop;
                    }
                }

                pow >>= 1;
            }
        }

        System.out.println(count);

        vec.forEach(System.out::println);

    }
}

class Node {
    long a;
    long b;

    Node(long a, long b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return this.a + " " + this.b;
    }
}