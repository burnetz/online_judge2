package atcoder.abc435;

import java.util.*;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] inputL = new int[q];
        int[] inputR = new int[q];
        NavigableSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(n + 1);

        for(int i = 0; i < q; i++) {
            inputL[i] = sc.nextInt();
            inputR[i] = sc.nextInt() + 1;

            treeSet.add(inputL[i]);
            treeSet.add(inputR[i]);
        }

        //入力で使用した数字を使って区間を細分化する。
        //4*10^5区間になる可能性があるが許容範囲。
        Range[] ranges = new Range[treeSet.size() - 1];
        Iterator<Integer> it = treeSet.iterator();
        int start = it.next();
        for(int i = 0; i < ranges.length; i++) {
            int end = it.next();
            ranges[i] = new Range(start, end);
            start = end;

        }

        //TreeSetを使えば該当する区間の検索がO(logQ)で可能。削除も高速。
        NavigableSet<Range> rangeSet = new TreeSet<>(Arrays.asList(ranges));

        int remain = n;
        Range endRange = new Range(n + 1, n + 2);

        //一見O(Q^2)だが、一度見た区間は削除されるので全体でO(Q logQ)となる。
        for(int i = 0; i < q; i++) {
            Range query = new Range(inputL[i], inputR[i]);

            SortedSet<Range> subSet = rangeSet.subSet(query, endRange);

            Iterator<Range> it2 = subSet.iterator();
            while(it2.hasNext()) {
                Range tmpRange = it2.next();
                if(tmpRange.start >= query.end) {
                    break;
                }
                it2.remove();

                remain -= tmpRange.end - tmpRange.start;
            }

            System.out.println(remain);

        }


    }
}

class Range implements Comparable<Range>{
    int start;
    int end;

    Range(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Range o) {
        return Integer.compare(this.start, o.start);
    }
}