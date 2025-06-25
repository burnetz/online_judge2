package atcoder.abc406;

import java.util.ArrayList;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();
        int n = sc.nextInt();

        ArrayList<Integer>[] listX = new ArrayList[w];
        ArrayList<Integer>[] listY = new ArrayList[h];

        for(int i = 0; i < w; i++) {
            listX[i] = new ArrayList();
        }
        for(int i = 0; i < h; i++) {
            listY[i] = new ArrayList();
        }

        for(int i = 0; i < n; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;

            listY[x].add(y);
            listX[y].add(x);
        }

        int removeCountY[] = new int[h];
        int removeCountX[] = new int[w];
        boolean allRemovedY[] = new boolean[h];
        boolean allRemovedX[] = new boolean[w];

        int q = sc.nextInt();

        for(int i = 0; i < q; i++) {
            int mode = sc.nextInt();

            switch (mode) {
                case 1 -> {
                    int c = sc.nextInt() - 1;

                    //処理済みの行は何もしない。
                    //ここでループ処理をしてしまうとカウントがずれる。
                    if(allRemovedY[c]) {
                        System.out.println(0);
                    }
                    else {
                        System.out.println(listY[c].size() - removeCountY[c]);

                        //影響がありそうなところにカウントを反映させる。
                        //最悪でも合計2N回しかこの処理は行われない。
                        for(int j = 0; j < listY[c].size() ; j++) {
                            int tmp = listY[c].get(j);
                            removeCountX[tmp]++;
                        }
                        allRemovedY[c] = true;
                    }
                }
                case 2 -> {
                    int r = sc.nextInt() - 1;

                    if(allRemovedX[r]) {
                        System.out.println(0);
                    }
                    else {
                        System.out.println(listX[r].size() - removeCountX[r]);

                        for(int j = 0; j < listX[r].size() ; j++) {
                            int tmp = listX[r].get(j);
                            removeCountY[tmp]++;
                        }
                        allRemovedX[r] = true;
                    }
                }
            }
        }


    }
}