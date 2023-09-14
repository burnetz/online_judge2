package atcoder.abc302;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class E {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        //各頂点に入る辺を管理する
        Set<Integer>[] in = new HashSet[n];
        for(int i = 0; i < n; i++) {
            in[i] = new HashSet<Integer>();
        }
        AtomicInteger isolate = new AtomicInteger(n);

        StringBuffer sb = new StringBuffer();
        //一見O(N^2)だがクエリ1では1本ずつしか追加できないため
        //削除のループを考えても実質Nの定数倍程度にしかならない。
        for(int i = 0; i < q; i++) {
            int mode = sc.nextInt();
            switch (mode) {
                case 1 -> {
                    int u = sc.nextInt() - 1;
                    int v = sc.nextInt() - 1;

                    if(in[u].size() == 0) {
                        isolate.getAndDecrement();
                    }

                    if(in[v].size() == 0) {
                        isolate.getAndDecrement();
                    }

                    in[u].add(v);
                    in[v].add(u);
                }
                case 2 -> {
                    int v = sc.nextInt() - 1;

                    in[v].forEach(u -> {
                        in[u].remove(v);
                        if(in[u].size() == 0) {
                            isolate.getAndIncrement();
                        }
                            }
                    );
                    if(in[v].size() != 0 ){
                        isolate.getAndIncrement();
                    }

                    in[v].clear();
                }
            }
            sb.append(isolate + "\n");
        }

        System.out.println(sb);
    }
}
