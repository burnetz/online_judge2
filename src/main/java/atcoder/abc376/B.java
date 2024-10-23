package atcoder.abc376;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        long sum = 0;
        int currentLeft = 0;
        int currentRight = 1;
        for(int i = 0; i < q; i++) {
            String side = sc.next();
            int target = sc.nextInt() - 1;

            switch (side) {
                case "R" -> {
                    if(target >= currentRight) {
                        if(target < currentLeft || currentRight > currentLeft) {
                            sum += target - currentRight;
                        }
                        else {
                            sum += currentRight + n - target;
                        }
                    }
                    else {
                        if(target > currentLeft || currentRight < currentLeft) {
                            sum += currentRight - target;
                        }
                        else {
                            sum += n - currentRight + target;
                        }
                    }
                    currentRight = target;
                }
                case "L" -> {
                    if(target >= currentLeft) {
                        if(target < currentRight || currentLeft > currentRight) {
                            sum += target - currentLeft;
                        }
                        else {
                            sum += currentLeft + n - target;
                        }
                    }
                    else {
                        if(target > currentRight || currentLeft < currentRight) {
                            sum += currentLeft - target;
                        }
                        else {
                            sum += n - currentLeft + target;
                        }
                    }
                    currentLeft = target;
                }

            }

//            System.out.println("Left " + (currentLeft + 1) + " right " + (currentRight + 1) + " sum " + sum);
        }
        System.out.println(sum);
    }
}