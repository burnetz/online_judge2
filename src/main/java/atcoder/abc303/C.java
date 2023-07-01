package atcoder.abc303;

import java.util.HashSet;
import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int h = sc.nextInt();
        int k = sc.nextInt();

        String command = sc.next();

        HashSet<String> items = new HashSet<>();

        for(int i = 0; i < m; i++){
            items.add(sc.next() + " " + sc.next());
        }

        int currentX = 0;
        int currentY = 0;

        for(int i = 0; i < n; i++){
            char c = command.charAt(i);

            switch (c) {
                case 'U' : currentY++;
                break;
                case 'D' : currentY--;
                break;
                case 'R' : currentX++;
                break;
                case 'L' : currentX--;
                break;
            }

            h--;

            String currentPos = currentX + " " + currentY;
            if(h < 0){
                System.out.println("No");
                return;
            }
            else if(items.contains(currentPos) && h < k){
                h = k;
                items.remove(currentPos);
            }
        }

        System.out.println("Yes");
    }
}
