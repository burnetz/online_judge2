package atcoder.abc387;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();

        //matrix[0] : 縦移動でしか来れない
        //matrix[1] : 横移動でしか来れない
        char[][][] matrix = new char[2][h][w];
        int[][][] cost = new int[2][h][w];

        int INF = 1_000_000_000;
        int startX = 0;
        int startY = 0;

        for(int i = 0; i < h; i++) {
            String s = sc.next();
            matrix[0][i] = s.toCharArray();
            matrix[1][i] = s.toCharArray();

            Arrays.fill(cost[0][i], INF);
            Arrays.fill(cost[1][i], INF);

            for(int j = 0; j < w; j++) {
                if(matrix[0][i][j] == 'S') {
                    startX = j;
                    startY = i;
                    cost[0][i][j] = cost[1][i][j] = 0;
                }
            }
        }

        Deque<Node> que = new ArrayDeque<>();

        que.add(new Node(0, startX, startY));
        que.add(new Node(1, startX, startY));

        int d[] = {-1, 1};
        while(!que.isEmpty()) {
            Node tmpNode = que.removeFirst();
            if(matrix[tmpNode.type][tmpNode.y][tmpNode.x] == 'G') {
                System.out.println(cost[tmpNode.type][tmpNode.y][tmpNode.x]);
                return;
            }

            for(int i = 0; i < 2; i++) {
                int nextType = 0;
                int dx = 0;
                int dy = 0;

                if(tmpNode.type == 0) {
                    nextType = 1;
                    dy = d[i];
                }
                else {
                    dx = d[i];
                }

                int tmpX = tmpNode.x + dx;
                int tmpY = tmpNode.y + dy;

                if(tmpX >= 0 && tmpX < w && tmpY >= 0 && tmpY < h
                        && matrix[nextType][tmpY][tmpX] != '#'
                        && cost[nextType][tmpY][tmpX] > cost[tmpNode.type][tmpNode.y][tmpNode.x] + 1){
                    cost[nextType][tmpY][tmpX] = cost[tmpNode.type][tmpNode.y][tmpNode.x] + 1;
                    que.add(new Node(nextType, tmpX, tmpY));
                }
            }
        }

        System.out.println(-1);
    }
}

class Node {
    int type;
    int x;
    int y;

    Node(int type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }
}