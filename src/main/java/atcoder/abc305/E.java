package atcoder.abc305;

import java.util.*;

public class E {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        ArrayList<Integer> edges[] = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            edges[a].add(b);
            edges[b].add(a);
        }

        //探索時点でのその頂点にいる警備員のHP最大値
        int knownMaxHp[] = new int[n];
        //HPの大きい順に探索を行う。
        PriorityQueue<Guard> pq = new PriorityQueue<>((a, b) -> b.hp - a.hp);
        boolean visited[] = new boolean[n];

        for(int i = 0; i < k ; i++){
            int a = sc.nextInt() - 1;
            int b = sc.nextInt();
            knownMaxHp[a] = b;
            pq.add(new Guard(a, b));
            visited[a] = true;
        }

        Set<Integer> sets[] = new HashSet[n];
        for(int i = 0; i < n; i++) {
            sets[i] = new HashSet<>();
        }

        //警備員がHPを消費して移動するということは
        //HPが１少ない警備員を新たに配置するのと同じ。
        //できるだけ同じ頂点での重複を防ぎつつBFSの要領で探索する。
        while(!pq.isEmpty()) {
            Guard u = pq.remove();
            knownMaxHp[u.pos] = Math.max(knownMaxHp[u.pos], u.hp);

            //この分岐に入るのは初期入力の警備員よりも新しい警備員のほうがHPが高い場合。
            if(u.hp < knownMaxHp[u.pos]) {
                continue;
            }

            //この分岐に入るのは探索すべき頂点がこの先にない場合。
            //周囲すべてからこの頂点が既に参照済みの場合そのように判断される。
            if(sets[u.pos].size() >= edges[u.pos].size()) {
                continue;
            }
            if(u.hp == 0) {
                break;
            }
            Iterator<Integer> it = edges[u.pos].iterator();
            while(it.hasNext()) {
                int v = it.next();

                //HPが十分高いところには向かう必要がない。
                if(knownMaxHp[v] != 0 && knownMaxHp[v] > u.hp) {
                    continue;
                }

                if(knownMaxHp[v] >= u.hp) {
                    continue;
                }

                //新しい警備員を配置する。
                pq.add(new Guard(v, u.hp - 1));
                sets[v].add(u.pos);

                visited[v] = true;
            }
        }

        int count = 0;
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < n; i++) {
            if(visited[i]) {
                count++;
                sb.append(i + 1).append(" ");
            }
        }

        System.out.println(count);
        System.out.println(sb);
    }
}

class Guard {
    int pos;
    int hp;

    Guard (int pos, int hp) {
        this.pos = pos;
        this.hp = hp;
    }
}