package testcase;

public class Utils {
    public static String NAME = "";

    public int add(int x, int y) {
        return x + y;
    }

    public int subtract(int x, int y) {
        return x - y;
    }

    public static void setName(String s) {
        System.out.println("Setting NAME to " + s);
        NAME = s;
    }
}
