package DZ_OOP_01_geo_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person ivan = new Person("Иван");
        Person lena = new Person("Елена", true);
        Person dima = new Person("Дмитрий");
        Person kate = new Person("Катя", true);

        ivan.setPartner(lena);
        ivan.addChildren(Arrays.asList(dima, kate));
        lena.addChildren(Arrays.asList(dima, kate));
        System.out.println(ivan.childrenAmount());
        System.out.println(lena.childrenAmount());
    }
}
