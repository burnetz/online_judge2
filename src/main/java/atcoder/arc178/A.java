package atcoder.arc178;

import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int a[] = Arrays.stream(new int[m]).map(e-> sc.nextInt()).sorted().toArray();

        //1で始まる長さ1および長さNの順列は必ず含んでしまうため不可。
        if(a[0] == 1 || a[m - 1] == n) {
            System.out.println(-1);
            return;
        }

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < m; i++) {
            set.add(a[i]);
        }

        StringBuffer result = new StringBuffer();
        Deque<Integer> que = new ArrayDeque<>();
        //基本的には小さい順に並べる。
        for(int i = 1; i <= n ; i++) {
            if(set.contains(i)) {
                que.addLast(i);
            }
            //Aは既にソート済みであるとして
            //A[i],A[i+1],...A[j]が連続する数字である場合は
            //A[i+1],A[i+2],...,A[j], (Aにない数字), A[i]とするのが最適。
            //もしA{i]がこれより前だと順列ができてしまう。
            else {
                if(que.isEmpty()) {
                    result.append(i + " ");
                }
                else {
                    int tmp = que.removeFirst();
                    while(!que.isEmpty()) {
                        result.append(que.removeFirst() + " ");
                    }
                    result.append(i + " " + tmp + " ");
                }
            }
        }
        System.out.println(result);
    }
}
