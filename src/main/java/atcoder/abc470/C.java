
package atcoder.abc470;

import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        int a[] = new int[n];
        //配列の要素を全て1減らすと間に合わないので
        //クエリ2のときにはオフセットがせり上がると考える。
        int offset = 0;
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < q; i++) {
            int mode = sc.nextInt();

            switch (mode) {
                case 1 -> {
                    int index = sc.nextInt() - 1;

                    //オフセットを下回る場合は見た目上の0（オフセットそのもの）となるよう補正する。
                    if(a[index] < offset) {
                        a[index] = offset;
                    }

                    //保存しておくべきはある数の登場回数自体ではなくその偶奇なので
                    //インクリメントに伴い切り替えを行う。
                    if (a[index] > offset) {
                        switchElement(set, a[index]);
                    }
                    a[index]++;
                    switchElement(set, a[index]);
                }
                case 2 -> {
                    offset++;

                    //オフセットがせり上がることで個数の保存が不要になるデータを削除する。
                    //該当する数字は高々1つ。
                    set.remove(offset);
                }
            }
            Iterator<Integer> it = set.iterator();
            int result = 0;
            //set内の全てのデータについて毎回XORを計算する。
            //一見強引だが問題の制約上それほど多くのデータがset内に保存されることはないので一応間に合う。
            while(it.hasNext()) {
                result ^= it.next() - offset;
            }

            System.out.println(result);
        }
    }

    static void switchElement(Set<Integer> set, int x) {
        if(set.contains(x)) {
            set.remove(x);
        }
        else {
            set.add(x);
        }
    }
}