package atcoder.abc352;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Giant giants[] = new Giant[n];

        for(int i = 0; i < n; i++) {
            giants[i] = new Giant(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(giants);

        long tmpHeight = giants[0].shoulder;
        for(int i = 1; i < n - 1; i++) {
            tmpHeight += giants[i].shoulder;
        }
        tmpHeight += giants[n - 1].head;

        System.out.println(tmpHeight);
    }
}

class Giant implements Comparable<Giant> {
    int shoulder;
    int head;

    Giant(int shoulder, int head) {
        this.shoulder = shoulder;
        this.head = head;
    }

    @Override
    public int compareTo(Giant g) {
        return (this.head - this.shoulder) - (g.head - g.shoulder);
    }
}