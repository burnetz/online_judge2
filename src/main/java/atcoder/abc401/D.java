package atcoder.abc401;

import java.util.Scanner;
import java.util.Vector;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        String str = sc.next();

        char[] result = new char[n];
        int oCount = 0;
        for(int i = 0; i < n; i++) {
            char c = str.charAt(i);
            switch (c) {
                //最優先事項として、もともと.またはoだった箇所はそのまま確定。
                case '.' -> result[i] = c;
                case 'o' -> {
                    result[i] = c;
                    oCount++;
                }
                case '?' -> {
                    //前後にoがある場合は.で確定。
                    if(i > 0 && str.charAt(i - 1) == 'o') {
                        result[i] = '.';
                    }
                    if(i < n - 1 && str.charAt(i + 1) == 'o') {
                        result[i] = '.';
                    }
                }
            }
        }

        Vector<Range> rangeVector = new Vector<>();
        for(int i = 0; i < n; i++) {
            if(result[i] == 0) {
                if(i == 0 || result[i - 1] != 0) {
                    rangeVector.add(new Range(i, 1));
                }
                else {
                    rangeVector.get(rangeVector.size() - 1).length++;
                }
            }
        }
        int capacity = 0;
        for(int i = 0; i < rangeVector.size(); i++) {
            capacity += (rangeVector.get(i).length + 1) / 2;
        }

        //?である全ての区間に最大限oを入れなければならないパターン
        if(capacity == k - oCount) {
            for(int i = 0; i < rangeVector.size(); i++) {
                Range range = rangeVector.get(i);

                for(int j = 0; j < range.length; j++) {
                    //この場合であっても文字が確定するのは?が奇数個続くパターンのみ
                    if(range.length % 2 == 1) {
                        if(j % 2 == 0) {
                            result[range.start + j] = 'o';
                        }
                        else {
                            result[range.start + j] = '.';
                        }
                    }
                    else {
                        result[range.start + j] = '?';
                    }
                }
            }
        }
        //?の区間にoが1回も登場しない場合は.で確定する。
        else if(k - oCount == 0) {
            for(int i = 0; i < n; i++) {
                if(result[i] == 0) {
                    result[i] = '.';
                }
            }
        }
        //それ以外の場合は何も確定しない。
        else {
            for(int i = 0; i < n; i++) {
                if(result[i] == 0) {
                    result[i] = '?';
                }
            }
        }


        System.out.println(result);
    }
}

class Range {
    int start;
    int length;

    public Range(int start, int length) {
        this.start = start;
        this.length = length;
    }
}