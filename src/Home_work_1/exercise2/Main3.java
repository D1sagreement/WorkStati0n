package Home_work_1.exercise2;

public class Main3 {
    public static void main(String[] args) {
        int a = 8;
        int result;
        boolean boolResult;

        result = 5 + 2 / a;
        System.out.println("5 + 2 / 8 = " + result);

        result = (5 + 2) / a;
        System.out.println("5 + 2 / 8 = " + result);

        int b1 = 2;
        result = (5 + b1) / a;
        b1++;
        System.out.println("(5 + 2 ++) / 8 = " + result);

        int b2 = 2;
        result = (5 + b2) / --a;
        b2++;
        System.out.println("(5 + 2++) / --8 = " + result);

        int b3 = 2;
        result = (5 * 2 >> b3) / --a;
        b3++;
        System.out.println("(5 * 2 >> 2++) / --8 = " + result);

        int b4 = 2;
        result = (5 + 7 > 20 ? 68 : 22 * 2 >> b4) / --a;
        b4++;
        System.out.println("(5 + 7 > 20 ? 68 : 22 * 2 >> b4) / --8 = "  + result);

        int b5 = 2;
        boolean c = (5 + 7 > 20 ? 68 >= 68 : (22 * 2 >> b5) > 0);
        b5++;
        System.out.println("(5 + 7 > 20 ? 68 >= 68 : (22 * 2 >> 2++) / --8 = " + result);

        boolResult = 6 - 2 > 3 && 12 * 12 <= 119;
        System.out.println("6 - 2 > 3 && 12 * 12 <= 119 = " +boolResult);

        boolResult = true && false;
        System.out.println("true && false = " + boolResult);




    }
}