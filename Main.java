package DZ_OOP_01_geo_tree;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Person godoslav = new Person("Годослав");
        Person godomisl = new Person("Годомысл");
        Person umila = new Person("Умила", true);
        Family.marry(godoslav, umila);
        Family.setParent(umila, godomisl);
        Person rurik = new Person("Рюрик");
        Person truvor = new Person("Трувор");
        Person sineus = new Person("Синеус");
        Family.addChildren(godoslav, umila, Arrays.asList(rurik, truvor, sineus));
        Person efanda = new Person("Ефанда", true);
        Family.marry(efanda, rurik);
        Person igor = new Person("Игорь");
        Person polata = new Person("Полата", true);
        Person sluda = new Person("Слуда");
        Person akun = new Person("Акун");
        Family.addChildren(rurik, Arrays.asList(igor, polata, sluda, akun));
        Family.addChildren(efanda, Arrays.asList(igor));
        Person olga = new Person("Прекрасна Ольга", true);
        Family.marry(olga, igor);

        System.out.println(Research.brothers(rurik));
        System.out.println(Research.parentsInLaw(efanda));
        System.out.println(Research.grandСhildren(godoslav));
        System.out.println(Research.grandParents(sluda));
    }
}
