package atcoder.arc172;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();
        int n = sc.nextInt();

        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).sorted().toArray();

        LinkedList<Rectangle> list = new LinkedList<>();
        list.add(new Rectangle(h, w));

loop:        for(int i = n - 1; i >= 0; i--) {
            int len = 1 << a[i];
            //長方形の左上から必要な分を切り取る。
            //残った部分で新しく最大3つの長方形ができる。
            //生成される長方形は高々3000なのでこの実装で間に合う。
            //また、切り取る正方形の1辺が必ず2のべき乗なので
            //ギリギリ切り取れる長方形を常に選べば無駄になる箇所は生じない。
            for(int j = 0; j < list.size() ; j++) {
                Rectangle tmpRect = list.get(j);
                if(tmpRect.height >= len) {
                    int remainW = tmpRect.width - len;
                    int remainH = tmpRect.height - len;

                    list.remove(j);

                    if(remainW != 0) {
                        insert(list, new Rectangle(remainW, len));
                    }
                    if(remainH != 0) {
                        insert(list, new Rectangle(remainH, len));
                    }
                    if(remainH != 0 && remainW != 0) {
                        insert(list, new Rectangle(remainH, remainW));
                    }
                    continue loop;
                }
            }

            System.out.println("No");
            return;
        }

        System.out.println("Yes");

    }

    //縦の長さについて昇順になるよう適切な箇所に挿入する。
    static void insert(LinkedList<Rectangle> list, Rectangle rect) {
        int index = Collections.binarySearch(list, rect);

        if(index < 0) {
            index++;
            index *= -1;
        }

        list.add(index, rect);
    }
}

class Rectangle implements Comparable <Rectangle> {
    int width;
    int height;

    //常に横長になるように
    Rectangle(int l1, int l2) {
        width = Math.max(l1, l2);
        height = Math.min(l1, l2);
    }

    @Override
    public int compareTo(Rectangle o) {
        return this.height - o.height;
    }
}