package atcoder.diverta20192;

import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).sorted().toArray();

        boolean positiveOnly = false;
        if(a[0] >= 0) {
            positiveOnly = true;
        }

        Deque<Long> positives = new ArrayDeque<>();
        Deque<Long> negatives = new ArrayDeque<>();
        if(positiveOnly) {
            //最大の値(a[n - 1])はそのまま使いたいので巻き込まない。
            for (int i = 1; i < n - 1; i++) {
                if (a[i] >= 0) {
                    positives.add((long) a[i]);
                }
            }
            //正の値しかないときは強引にa[0]を負の値と同等に扱う。
            //これが最も損失が少ない。
            negatives.add((long)a[0]);
        }
        else {
            //最大の値を除いて全てリストに振り分ける。
            for (int i = 0; i < n - 1; i++) {
                if (a[i] > 0) {
                    positives.add((long) a[i]);
                } else {
                    negatives.add((long) a[i]);
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        //正の数を引き続けることでとても絶対値の大きな負の数ができる。
        //後でそれを引くことで大きな正の値の加算と同じ扱いになる。
        long tmpSum = negatives.removeFirst();
        while(!positives.isEmpty()) {
            long tmp = positives.removeFirst();
            sb.append(tmpSum + " " + tmp + "\n");
            tmpSum -= tmp;
        }

        //負の数は引くことで加算と同じ扱いになる。
        negatives.add(tmpSum);
        tmpSum = a[n - 1];
        while(!negatives.isEmpty()) {
            long tmp = negatives.removeFirst();
            sb.append(tmpSum + " " + tmp + "\n");
            tmpSum -= tmp;
        }

        System.out.println(tmpSum);
        System.out.println(sb);
    }
}
