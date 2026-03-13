package atcoder.abc448;

import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        Pair[] pairs = new Pair[n];
        for(int i = 0; i < n; i++) {
            pairs[i] = new Pair(i, a[i]);
        }

        Arrays.sort(pairs, Comparator.comparingInt(Pair::value));

        for(int i = 0; i < q; i++) {
            int k = sc.nextInt();

            Set<Integer> set = new HashSet<>();
            for(int j = 0; j < k; j++) {
                set.add(sc.nextInt() - 1);
            }

            for(int j = 0; j < n; j++) {
                if(!set.contains(pairs[j].index())) {
                    System.out.println(pairs[j].value());
                    break;
                }
            }
        }
    }
}

record Pair (int index, int value){

}