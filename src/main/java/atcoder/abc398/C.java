package atcoder.abc398;

import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        Holder[] holders = new Holder[n];
        for(int i = 0; i < n; i++) {
            holders[i] = new Holder(i + 1, a[i]);
        }

        Arrays.sort(holders);

        int result = -1;
        for(int i = 0; i < n; i++) {
            if((i == 0 || holders[i - 1].value != holders[i].value) && (i == n - 1 || holders[i].value != holders[i + 1].value)) {
                result = holders[i].id;
            }
        }

        System.out.println(result);
    }
}

class Holder implements Comparable<Holder> {
    int id;
    int value;

    Holder(int id, int value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public int compareTo(Holder o) {
        return Integer.compare(this.value, o.value);
    }
}