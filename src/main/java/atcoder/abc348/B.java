package atcoder.abc348;

import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Point[] points = new Point[n];
        for(int i = 0; i < n; i++) {
            points[i] = new Point(i + 1, sc.nextInt(), sc.nextInt());
        }

        for(int i = 0; i < n; i++) {
            int tmpDist = 0;
            int index = -1;
            for(int j = 0; j < n; j++) {
                if(tmpDist < points[i].distanceSq(points[j])) {
                    tmpDist = points[i].distanceSq(points[j]);
                    index = points[j].id;
                }
            }

            System.out.println(index);
        }
    }
}

class Point {
    int x;
    int y;
    int id;

    Point(int id, int x, int y) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    int distanceSq(Point p) {
        return (int)Math.pow(this.x - p.x, 2) + (int)Math.pow(this.y - p.y, 2);
    }
}