package atcoder.wtf22day1a;

import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int x[] = Arrays.stream(new int[m]).map(e -> sc.nextInt() - 1).toArray();

        Monster monsters[] = new Monster[n];
        for(int i = 0; i < n; i++) {
            monsters[i] = new Monster(i);
        }

        for(int i = 0; i < m; i++) {
            monsters[x[i]].attacked++;
        }

        //攻撃される回数について昇順にソートする。
        Arrays.sort(monsters);
        //いずれのモンスターも攻撃を一度受けると死ぬので
        //魔王にとっっての最適解は攻撃される回数の少ないモンスターを
        //MPが続く限り守り続けること。
        int result = 0;
        for(int i = 0; i < n; i++) {
            //勇者のMPが既に尽きている場合
            if(a <= 0) {
                result++;
            }
            else {
                int attackTime = Math.min(a, monsters[i].attacked);

                //途中で魔王のMPが尽きる場合
                if(attackTime > b) {
                    a -= b + 1;
                    b = 0;
                }
                //魔王がモンスターを守りきった場合
                else {
                    a -= attackTime;
                    b -= attackTime;

                    result++;
                }
            }
        }

        System.out.println(result);
    }
}

class Monster implements Comparable<Monster> {
    int id;
    int attacked;

    Monster(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Monster o) {
        return Integer.compare(this.attacked, o.attacked);
    }
}
