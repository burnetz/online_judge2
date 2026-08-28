package atcoder.abc439;

import java.util.*;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Person[] people = new Person[n];

        for(int i = 0; i < n; i++) {
            people[i] = new Person(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(people, (e1, e2) -> {
            if(e1.a() != e2.a()) {
                return Integer.compare(e1.a(), e2.a());
            }
            //aの座標が同じものが含まれているので注意。
            //このときbについて降順でソートしないとLISとして解くことができなくなる。
            else {
                return Integer.compare(e2.b(), e1.b());
            }
        });
        int a[] = new int[n];
        int b[] = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = people[i].a();
            b[i] = people[i].b();
        }

        int INF = 2_000_000_000;

        double dp[] = new double[n];

        Arrays.fill(dp, INF);
        //凧を上げる向きが右向きか左向きかによって様々な状況があり得るが
        //結局「aとbがともに大きければ共存可能」ということに変わりはない。
        //aについては既にソート済みなのでbについてLISと同じ考え方で解くことができる。
        for(int i = 0; i < n; i++) {
            int index = Arrays.binarySearch(dp, b[i] - 0.5);
            index++;
            index *= -1;

            dp[index] = b[i];
        }

        int index = Arrays.binarySearch(dp, INF - 0.5);
        index++;
        index *= -1;

        System.out.println(index);
    }
}

record Person (int a, int b) {}