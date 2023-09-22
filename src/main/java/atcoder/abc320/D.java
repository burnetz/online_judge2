package atcoder.abc320;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        points = new Point[n];
        points = Arrays.stream(points).map(e -> new Point()).toArray(Point[]::new);

        lists = new ArrayList[n];
        lists = Arrays.stream(lists).map(e -> new ArrayList<Edge>()).toArray(ArrayList[]::new);

        int m = sc.nextInt();
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int x = sc.nextInt();
            int y = sc.nextInt();

            lists[a].add(new Edge(b, x, y));
            lists[b].add(new Edge(a, -x, -y));
        }

        dfs(0, 0, 0);

        Arrays.stream(points).forEach(Point::toString);

        //最初の頂点から始めてdfsで触れなかったものは到達不可。
        //それ以外は座標が一意に定まる。
        StringBuffer sb = new StringBuffer();
        Arrays.stream(points).forEach(p -> {
            if(p.initialized()) {
                sb.append(p.x + " " + p.y + "\n");
            }
            else {
                sb.append("undecidable\n");
            }
        });
        System.out.println(sb);
    }

    static Point[] points;
    static ArrayList<Edge>[] lists;

    static void dfs(int index, long x, long y) {
        points[index].init(x, y);

        lists[index].forEach(edge -> {
            if(!points[edge.to].initialized()) {
                dfs(edge.to, x + edge.x, y + edge.y);
            }
        });

    }
}

class Point {
    long x;
    long y;
    boolean init = false;

    void init(long x, long y) {
        this.x = x;
        this.y = y;
        init = true;
    }

    boolean initialized() {
        return init;
    }
}
class Edge {
    int to;
    long x;
    long y;

    Edge (int to, int x, int y) {
        this.to = to;
        this.x = x;
        this.y = y;
    }
}