package atcoder.abc370;

import java.util.Scanner;
import java.util.Vector;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char s[] = sc.next().toCharArray();
        char t[] = sc.next().toCharArray();

        Vector<String> vec = new Vector<>();
        while(!new String(s).equals(new String(t))) {
            int last = -1;
            for(int i = 0; i < s.length; i++) {
                if(s[i] != t[i]) {
                    last = i;

                    if(s[i] > t[i]) {
                        s[i] = t[i];
                        break;
                    }
                }

                if(i == s.length - 1) {
                    s[last] = t[last];
                }
            }

            vec.add(new String(s));
        }

        System.out.println(vec.size());
        vec.stream().forEach(System.out::println);
    }
}