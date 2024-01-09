package atcoder.abc335;

import java.awt.geom.Point2D;
import java.util.Scanner;
import java.util.Vector;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        //頭についてだけ移動の記録を残す。
        Vector<Point2D.Double> vec = new Vector<>();
        vec.add(new Point2D.Double(1, 0));

        int dx[] = {0, 1, 0, -1};
        int dy[] = {1, 0, -1, 0};

        for(int i = 0; i < q; i++) {
            int mode = sc.nextInt();

            switch (mode) {
                case 1 -> {
                    String command = sc.next();
                    int dir = 0;
                    switch (command) {
                        case "U" -> {
                            dir = 0;
                        }
                        case "R" -> {
                            dir = 1;
                        }
                        case "D" -> {
                            dir = 2;
                        }
                        case "L" -> {
                            dir = 3;
                        }
                    }
                    Point2D point = vec.lastElement();
                    vec.add(new Point2D.Double(point.getX() + dx[dir], point.getY() + dy[dir]));
                }
                case 2 -> {
                    int target = sc.nextInt();

                    //基本的には頭の軌跡の中から該当するデータを探せば良いが
                    //頭の初期位置までtargetが移動していない場合は軌跡を参照できない。
                    //その場合はX軸上にいるはず。
                    if(vec.size() <= target) {
                        System.out.println(target - vec.size() + 1 + " 0");
                    }
                    else {
                        Point2D p = vec.get(vec.size() - target);

                        System.out.println((int)p.getX() + " " + (int)p.getY());
                    }
                }
            }

        }
    }
}
