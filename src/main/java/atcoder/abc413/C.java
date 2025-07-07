package atcoder.abc413;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();

        Deque<Element> que = new ArrayDeque<>();

        for(int i = 0; i < q; i++) {
            int mode = sc.nextInt();

            switch (mode) {
                case 1 -> {
                    int c = sc.nextInt();
                    int x = sc.nextInt();

                    que.addLast(new Element(x, c));
                }
                case 2 -> {
                    int x = sc.nextInt();
                    long sum = 0;

                    while(true) {
                        Element top = que.getFirst();

                        int tmpCount = Math.min(top.count, x);

                        sum += (long)top.value * tmpCount;
                        x -= tmpCount;
                        top.count -= tmpCount;

                        if(top.count == 0) {
                            que.removeFirst();
                        }

                        if(x == 0) {
                            break;
                        }

                    }

                    System.out.println(sum);
                }
            }
        }
    }
}

class Element {
    int value;
    int count;

    Element(int value, int count) {
        this.value = value;
        this.count = count;
    }
}