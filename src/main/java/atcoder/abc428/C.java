package atcoder.abc428;

import java.util.Scanner;
import java.util.Stack;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();

        int currentLength = 0;
        //削除さえなければstackでチェックするのが早いが
        //今回はそうもいかないのでインデックスごとに深さを常時管理する
        int[] level = new int[q + 1];

        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();

            switch (type) {
                case 1 -> {
                    String s = sc.next();
                    char c = s.toCharArray()[0];
                    currentLength++;

                    switch (c) {
                        case '(' -> {
                            level[currentLength] = level[currentLength - 1] + 1;

                        }
                        case ')' -> {
                            //()のペアが成立する場合
                            if(level[currentLength - 1] > 0) {
                                level[currentLength] = level[currentLength - 1] - 1;
                            }
                            //)が過剰である場合はその先レベルが0になることはない。
                            else {
                                level[currentLength] = -1_000_000_000;
                            }

                        }

                    }
                }
                case 2 -> {
                    currentLength--;

                }
            }

            if(level[currentLength] == 0) {
                System.out.println("Yes");
            }
            else {
                System.out.println("No");
            }
        }

    }
}