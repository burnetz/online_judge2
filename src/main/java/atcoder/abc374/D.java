package atcoder.abc374;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        lines = new Line[n];
        used = new boolean[n];
        speedWithoutLaser = sc.nextInt();
        speedWithLaser = sc.nextInt();

        for(int i = 0; i < n; i++) {
            lines[i] = new Line(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        dfs(0, n, 0, new Point(0, 0));
        System.out.println(result);
    }

    static Line[] lines;
    static boolean[] used;
    static double result = Double.MAX_VALUE;
    static double speedWithLaser;
    static double speedWithoutLaser;

    //DFSで全探索可能。順番も自由なので注意。
    static void dfs(int currentDepth, int maxDepth, double currentResult, Point currentPos) {
        if(currentDepth == maxDepth) {
            result = Math.min(result, currentResult);
            return;
        }

        for(int i = 0; i < maxDepth; i++) {
            if(used[i]) {
                continue;
            }

            used[i] = true;
            //Lineのどちら側の頂点から始めるかで結果が変わるので2パターン試す。
            dfs(currentDepth + 1, maxDepth,
                    currentResult + currentPos.calcDistance(lines[i].p1) / speedWithoutLaser + lines[i].getLength() / speedWithLaser,
                    lines[i].p2);
            dfs(currentDepth + 1, maxDepth,
                    currentResult + currentPos.calcDistance(lines[i].p2) / speedWithoutLaser + lines[i].getLength() / speedWithLaser,
                    lines[i].p1);
            used[i] = false;
        }
    }
}

class Line {
    Point p1, p2;

    Line(int x1, int y1, int x2, int y2) {
        this.p1 = new Point(x1, y1);
        this.p2 = new Point(x2, y2);
    }

    double getLength() {
        return p1.calcDistance(p2);
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    double calcDistance(Point p) {
        return Math.sqrt((double) (this.x - p.x) * (this.x - p.x) + (this.y - p.y) * (this.y - p.y));
    }
}