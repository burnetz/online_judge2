package atcoder.abc449;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int l = sc.nextInt();
        int r = sc.nextInt();
        int d = sc.nextInt();
        int u = sc.nextInt();

        long result = 0;

        //x軸、y軸、対角線によって領域を8つに分けると計算がしやすい。

        //reg0
        if(u >= 0) {
            for (int i = Math.max(1, l); i <= Math.max(1, r); i++) {
                if (i % 2 == 1) {
                    continue;
                }

                int tmp =  Math.min(i, u + 1) - Math.max(0, d);
                if(tmp > 0) {
                    result += tmp;
                }
            }
        }

        //reg1
        if(r > 0) {
            for (int i = Math.max(1, d); i <= Math.max(1, u); i++) {
                if (i % 2 == 1) {
                    continue;
                }

                int tmp = -(Math.max(0, l - 1) - Math.min(i, r));
                if(tmp > 0) {
                    result += tmp;
                }
            }
        }

        //reg2
        if(l <= 0) {
            for (int i = Math.max(1, d); i <= Math.max(1, u); i++) {
                if (i % 2 == 1) {
                    continue;
                }

                int tmp = Math.min(0, r) - Math.max(-i, l - 1);
                if(tmp > 0) {
                    result += tmp;
                }
            }
        }

        //reg3
        if(u > 0) {
            for (int i = Math.min(-1, l); i <= Math.min(-1, r); i++) {
                if (i % 2 != 0) {
                    continue;
                }

                int tmp = Math.min(-i, u) - Math.max(0, d - 1);
                if(tmp > 0) {
                    result += tmp;
                }
            }
        }

        //reg4
        if(d <= 0) {
            for (int i = Math.min(-1, l); i <= Math.min(-1, r); i++) {
                if (i % 2 != 0) {
                    continue;
                }

                int tmp = Math.min(0, u) - Math.max(i, d - 1);
                if(tmp > 0) {
                    result += tmp;
                }
            }
        }

        //reg5
        if(l < 0) {
            for (int i = Math.min(-1, d); i <= Math.min(-1, u); i++) {
                if (i % 2 != 0) {
                    continue;
                }

                int tmp = Math.min(0, r + 1) - Math.max(i, l);
                if(tmp > 0) {
                    result += tmp;
                }
            }
        }

        //reg6
        if(r >= 0) {
            for (int i = Math.min(-1, d); i <= Math.min(-1, u); i++) {
                if (i % 2 != 0) {
                    continue;
                }

                int tmp = Math.min(-i, r + 1) - Math.max(0, l);
                if(tmp > 0) {
                    result += tmp;
                }
            }
        }

        //reg7
        if(d < 0) {
            for (int i = Math.max(1, l); i <= Math.max(1, r); i++) {
                if (i % 2 != 0) {
                    continue;
                }

                int tmp = Math.min(0, u + 1) - Math.max(-i, d);
                if(tmp > 0) {
                    result += tmp;
                }
            }
        }

        //原点は別扱い。
        if(l <= 0 && r >= 0 && u >= 0 && d <= 0) {
            result++;
        }
        System.out.println(result);
    }
}