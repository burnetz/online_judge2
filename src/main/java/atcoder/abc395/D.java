package atcoder.abc395;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int pegions[] = new int[n + 1];
        for(int i = 0; i < pegions.length; i++) {
            pegions[i] = i;
        }

        //スワップはラベルの付け替えで対応する。
        //常に逆引きもできるようにする。
        int id[] = new int[n + 1];
        Map<Integer, Integer> idReverse = new HashMap();
        for(int i = 0; i < id.length; i++) {
            id[i] = i;
            idReverse.put(i, i);
        }

        int q = sc.nextInt();

        for(int i = 0; i < q; i++) {
            int mode = sc.nextInt();

            switch (mode) {
                case 1 -> {
                    int a = sc.nextInt();
                    int b = sc.nextInt();

                    //単体の移動は実際に居場所を更新する。
                    pegions[a] = id[b];
                }
                case 2 -> {
                    int a = sc.nextInt();
                    int b = sc.nextInt();

                    //スワップはラベルの付替え。鳩は動かさない。
                    int tmp = id[a];
                    id[a] = id[b];
                    idReverse.put(id[b], a);
                    id[b] = tmp;
                    idReverse.put(tmp, b);
                }
                default -> {
                    int a = sc.nextInt();

                    System.out.println(idReverse.get(pegions[a]));
                }
            }
        }
    }
}