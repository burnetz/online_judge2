package atcoder.abc386;

import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Point[] points = new Point[m];

        //座標圧縮の準備用（y座標は圧縮しなくて良い）
        PriorityQueue<Integer> pqX = new PriorityQueue<>();

        for(int i = 0; i < m; i++) {
            points[i] = new Point(sc.nextInt(), sc.nextInt(), sc.next().charAt(0));
            pqX.add(points[i].x);
        }

        Map<Integer, Integer> mapX = new HashMap<>();

        while(!pqX.isEmpty()) {
            int tmp = pqX.remove();

            if(!mapX.containsKey(tmp)) {
                mapX.put(tmp, mapX.size());
            }
        }

        Vector<Point> black = new Vector<>();
        Vector<Point> white = new Vector<>();
        for(int i = 0; i < m; i++) {
            if(points[i].color == 'B') {
                black.add(points[i]);
            }
            else {
                white.add(points[i]);
            }
        }

        //y座標の大きい順に並べる。
        Collections.sort(black, (o1, o2) -> Integer.compare(o2.y, o1.y));

        int maxBlack[] = new int[mapX.size()];
        int checked = -1;
        //O(M^2)に見えるがcheckedは単調増加なので結果的にはO(M)程度で済む。
        for(int i = 0; i < black.size() ; i++) {
            Point tmpPoint = black.get(i);
            //黒確定のマス含めこれより左の未チェック区間は同じy座標になる。
            //この塗り方で黒マスが最小限になる。
            for(int j = checked + 1; j <= mapX.get(tmpPoint.x); j++) {
                maxBlack[j] = tmpPoint.y;
                checked = j;
            }

        }

        for(int i = 0; i < white.size(); i++) {
            Point tmpPoint = white.get(i);
            if(tmpPoint.y <= maxBlack[mapX.get(tmpPoint.x)]) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");

    }
}

class Point {
    int x;
    int y;
    char color;

    public Point(int x, int y, char color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
}