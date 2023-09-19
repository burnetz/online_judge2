package atcoder.abc304;

import java.util.*;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int w = sc.nextInt();
        int h = sc.nextInt();
        int n = sc.nextInt();

        Point[] points = new Point[n];

        for(int i = 0; i < n; i++) {
            points[i] = new Point(sc.nextInt(), sc.nextInt());
        }

        int a = sc.nextInt();
        Vector<Integer> vertical = new Vector<>();
        vertical.add(0);

        for(int i = 0; i < a; i++) {
            vertical.add(sc.nextInt());
        }
        vertical.add(w);

        int b = sc.nextInt();
        Vector<Integer> horizontal = new Vector<>();
        horizontal.add(0);

        for(int i = 0; i < b; i++) {
            horizontal.add(sc.nextInt());
        }

        Map<String, Integer> map = new HashMap<>();

        //各区画ごとの出現回数を記録する。
        for(int i = 0; i < n; i++) {
            String key = convertValue(vertical, points[i].x) + ", " + convertValue(horizontal, points[i].y);

            map.merge(key, 1, (num1, num2) -> num1 + 1);
        }

        int min = map.values().stream().min(Integer::compareTo).get();
        int max = map.values().stream().max(Integer::compareTo).get();

        //上の処理では登場回数0の区画は把握できないが
        //全部で何区画処理したかを考えれば0の有無は求められる。
        if(map.size() < ((long)a + 1) * (b + 1)) {
            min = 0;
        }

        System.out.println(min + " " + max);
    }

    //同じ区画内であれば同じ値になるよう変換するためのメソッド
    static int convertValue(Vector<Integer> vec, int value) {
        //境界線上には点は無いのでこのバイナリサーチは必ず失敗する。
        int index = Collections.binarySearch(vec, value);

        index++;
        index *= -1;

        return index;
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}