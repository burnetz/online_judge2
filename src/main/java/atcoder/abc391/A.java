package atcoder.abc391;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String dest = sc.next();

        String result;

        switch (dest) {
            case "N" -> {
                result = "S";
            }
            case "NE" -> {
                result = "SW";

            }
            case "E" -> {
                result = "W";

            }
            case "SE" -> {
                result = "NW";

            }
            case "S" -> {
                result = "N";

            }
            case "SW" -> {
                result = "NE";

            }
            case "W" -> {
                result = "E";

            }
            default -> {
                result = "SE";

            }
        }
        System.out.println(result);
    }
}