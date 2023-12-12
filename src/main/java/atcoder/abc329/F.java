package atcoder.abc329;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class F {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        int color[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        //箱ごとに色の種類を管理する（メモリ的には一応間に合う）
        Set<Integer> sets[] = new HashSet[n];
        for(int i = 0; i < n; i++) {
            sets[i] = new HashSet<>();
            sets[i].add(color[i]);
        }

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < q; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            //setの中身の合成とクリアを行う。
            if(sets[a].size() < sets[b].size()) {
                sets[b].addAll(sets[a]);
                sets[a].clear();
            }
            //ただし移動先よりも移動元の方が要素数が多い場合は
            //逆に操作をしてスワップした方が速い。
            else {
                sets[a].addAll(sets[b]);
                sets[b].clear();
                Set<Integer> tmp = sets[a];
                sets[a] = sets[b];
                sets[b] = tmp;
            }

            sb.append(sets[b].size() + "\n");
        }
        System.out.print(sb);
    }
}