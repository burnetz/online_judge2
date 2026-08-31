package atcoder.abc445;

import java.util.PriorityQueue;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();
        int n = sc.nextInt();

        Rect[] rectangles = new Rect[n];
        PriorityQueue<Rect> pqH = new PriorityQueue<>((e1, e2) -> Integer.compare(e2.h, e1.h));
        PriorityQueue<Rect> pqW = new PriorityQueue<>((e1, e2) -> Integer.compare(e2.w, e1.w));

        for(int i = 0; i < n; i++) {
            rectangles[i] = new Rect(sc.nextInt(), sc.nextInt());
            pqH.add(rectangles[i]);
            pqW.add(rectangles[i]);
        }

        //最初に割るときは縦か横のどちらかは元々の長方形と一致するはず。
        //そして縦も横も小さくなる一方なのであらかじめ降順にソートしておくと条件を満たすものを探しやすい。
        while(!pqH.isEmpty() && !pqW.isEmpty()) {
            while(!pqH.isEmpty() && pqH.peek().used) {
                pqH.poll();
            }
            while(!pqW.isEmpty() && pqW.peek().used) {
                pqW.poll();
            }

            //基本的に奥から割るように統一すればOK。割るたびに縦もしくは横の大きさが更新される。
            if(!pqH.isEmpty() && h == pqH.peek().h) {
                Rect tmpRect = pqH.poll();
                tmpRect.x = w - tmpRect.w + 1;
                tmpRect.y = 1;
                w -= tmpRect.w;
                tmpRect.used = true;
            }
            if(!pqW.isEmpty() && w == pqW.peek().w) {
                Rect tmpRect = pqW.poll();
                tmpRect.y = h - tmpRect.h + 1;
                tmpRect.x = 1;
                h -= tmpRect.h;
                tmpRect.used = true;
            }
        }

        for(int i = 0; i < n; i++) {
            System.out.println(rectangles[i].y + " " + rectangles[i].x);
        }
    }
}

class Rect {
    int h;
    int w;
    int x;
    int y;
    boolean used;

    Rect (int h, int w) {
        this.h = h;
        this.w = w;
    }
}