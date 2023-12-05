package atcoder.abc331;

import java.util.*;

public class E {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int l = sc.nextInt();

        Node[] a = new Node[n];
        for(int i = 0; i < n; i++) {
            a[i] = new Node(i, sc.nextInt());
        }

        Node[] b = new Node[m];
        for(int i = 0; i < m; i++) {
            b[i] = new Node(i, sc.nextInt());
        }

        //おいしさについて降順
        Arrays.sort(a);
        Arrays.sort(b);

        Set<String> set = new HashSet<>();
        for(int i = 0; i < l; i++) {
            int c = sc.nextInt() - 1;
            int d = sc.nextInt() - 1;

            set.add(c + "," + d);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((s, t) -> t - s);
        //a[i]について合計が最大となるb[j]を探す。
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m ; j++) {
                //禁止されている組み合わせでないならその組み合わせが最適。
                //以降はb[j]を探す必要がない。
                //禁止集合は100000しかないのでループの回数はそこまで多くならない。
                if(!set.contains(a[i].id + "," + b[j].id)) {
                    pq.add(a[i].value + b[j].value);
                    break;
                }
            }
        }

        System.out.println(pq.remove());
    }
}

class Node implements Comparable<Node>{
    int id;
    int value;

    Node(int id, int value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return o.value - this.value;
    }
}