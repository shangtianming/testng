package other;

public class test {
    public static void main(String[] args) {
        int t1 = 12;
        int t2 = 12;

        Integer integer1 = new Integer(12);
        Integer integer2 = new Integer(12);
        Integer integer3 = new Integer(127);

        Integer a1 = 127; //或者写成Integer a1 = Integer.valueOf(127);
        Integer a2 = 127;//或者写成Integer a2 = Integer.valueOf(127);

        Integer a = 128;
        Integer b = 128;

        // 基本数据类型==比较只要值相等就为true
        System.out.println("2个int类型比较 -> " + (t1 == t2));
        // Integer与int进行==比较时，Integer就会拆箱成一个int类型，所以还是相当于两个int类型进行比较
        System.out.println("int和integer比较 -> " + (t1 == integer1));
        // 两个都是对象类型，而且不会进行拆箱比较
        System.out.println("2个new出来的integer比较 -> " + (integer1 == integer2));
        // 无论如何，Integer与new Integer不会相等。不会经历拆箱过程，因为它们存放内存的位置不一样。
        System.out.println("integer3 == a1 -> " + (integer3 == a1));

        // Integer作为变量时，对于-128到127之间的数，会进行缓存，再次创建直接拿原来的赋值给变量。
        // 超出这个范围，则会new一个对象
        System.out.println("a1 == a2 -> " + (a1 == a2));
        System.out.println("a == b -> " + (a == b));
    }
}
