package atcoder.abc455;

import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).sorted().toArray();

        long sum = 0;

        Vector<Long> vec = new Vector<>();
        for(int i = 0; i < n; i++) {
            if(i == 0 || a[i - 1] != a[i]) {
                vec.add((long)a[i]);
            }
            else {
                long tmp = vec.lastElement() + a[i];
                vec.remove(vec.size() - 1);
                vec.add(tmp);
            }
        }

        Collections.sort(vec);

        for(int i = 0; i < vec.size() - k; i++) {
            sum += vec.get(i);
        }

        System.out.println(sum);

    }
}