package atcoder.abc298;

import java.util.*;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();
        //クエリ2では重複を考えクエリ3では重複を無視するので
        //それぞれPriorityQueueとSortedSetが良い。
        PriorityQueue<Integer>[] pqX = new PriorityQueue[n + 1];
        SortedSet<Integer>[] setY = new SortedSet[200000 + 1];
        for(int i = 0; i <= n; i++){
            pqX[i] = new PriorityQueue<Integer>();
        }

        for(int i = 0; i < setY.length; i++){
            setY[i] = new TreeSet<Integer>();
        }
        for(int i = 0; i < q; i++){
            int mode = sc.nextInt();
            switch (mode) {
                case 1 :
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    pqX[b].add(a);
                    setY[a].add(b);
                    break;
                case 2 :
                    a = sc.nextInt();
                    Deque<Integer> deq = new ArrayDeque<Integer>();
                    StringBuffer sb = new StringBuffer();
                    while(!pqX[a].isEmpty()){
                        int tmp = pqX[a].remove();
                        sb.append(tmp + " ");
                        deq.add(tmp);
                    }
                    System.out.println(sb);

                    while(!deq.isEmpty()){
                        pqX[a].add(deq.removeFirst());
                    }
                    break;
                case 3 :
                    a = sc.nextInt();
                    sb = new StringBuffer();
                    setY[a].stream().forEach(n1 -> sb.append(n1 + " "));
                    System.out.println(sb);
            }
        }
    }
}
