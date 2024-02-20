package atcoder.abc341;

import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        height = sc.nextInt();
        width = sc.nextInt();
        int n = sc.nextInt();

        command = sc.next();

        matrix = new char[height][width];
        for(int i = 0; i < height; i++ ) {
            matrix[i] = sc.next().toCharArray();
        }

        int count = 0;
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(check(j, i)) {
                    count++;
                }
            }
        }

        System.out.println(count);

    }

    static int height;
    static int width;
    static char[][] matrix;
    static String command;

    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};

    //横幅縦幅ともに大きくないので全パターン確認可能
    static boolean check(int x, int y) {
        for(int i = 0; i <= command.length(); i++) {
            if(!inRange(x, y) || matrix[y][x] == '#') {
                return false;
            }

            if(i == command.length()) {
                break;
            }

            int index = 0;
            switch (command.charAt(i)) {
                case 'U' -> index = 0;
                case 'R' -> index = 1;
                case 'D' -> index = 2;
                default -> index = 3;
            }

            x += dx[index];
            y += dy[index];
        }

        return true;
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
}
