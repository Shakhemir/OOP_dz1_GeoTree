package DZ_OOP_01_geo_tree;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Person ivan = new Person("Иван");
        Person lena = new Person("Елена", true);
        Person dima = new Person("Дмитрий");
        Person kate = new Person("Катя", true);

        Family.marry(ivan, lena);
        Family.addChildren(ivan, lena, Arrays.asList(dima, kate));
        System.out.println(ivan);
        System.out.println(lena);
    }
}
