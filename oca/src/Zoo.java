/**
  Created by William on 3/21/2017.
 */


public class Zoo {
    public static void main(String[] args) {
        System.out.println("Welcome");
        System.out.println(args[0]);
        System.out.println(args[1]);
        String x = null;
        System.out.println(x);
        boolean y = false;
        System.out.println(y);
        double amt = 0xE;
        System.out.println(amt);
        System.out.println("0b110000111000 = " + 0b110000111000);
        double x2 = 39.21;
        System.out.println("double x2 = " + x2);
        float y2 = 2.1f;
        System.out.println("float y2 = " + y2);
        System.out.println("y2 + x2 = " + (y2 + x2));
        int z = 1;
        int m = 1;
        int p = 0;
        while (p < 10) {
            p = m < 10 ? m++ : z++;
            System.out.println("m = " + m + " | z = " + z);
        }

    }
}