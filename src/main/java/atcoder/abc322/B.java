package atcoder.abc322;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        String subStr = sc.next();
        String str = sc.next();

        Pattern prefix = Pattern.compile("^" + subStr  + ".*");
        Pattern suffix = Pattern.compile(".*" + subStr + "$");

        Matcher prefixMatcher = prefix.matcher(str);
        Matcher suffixMatcher = suffix.matcher(str);

        if(prefixMatcher.matches() && suffixMatcher.matches()) {
            System.out.println(0);
        }
        else if(prefixMatcher.matches()) {
            System.out.println(1);
        }
        else if(suffixMatcher.matches()) {
            System.out.println(2);
        }
        else {
            System.out.println(3);
        }

    }
}
