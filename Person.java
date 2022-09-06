package DZ_OOP_01_geo_tree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    public String name;
    public boolean isFemale;  // false - мужской пол, true - женский пол
    public Person father;
    public Person mother;
    public boolean isMarried;  // статус брака
    public Person partner;  // муж / жена
    public List<Person> children;  // дети (список)

    public Person(String name) {
        this.name = name;
        this.isMarried = false;
        this.isFemale = false;
        // по умолчанию добавляются неизвестные родители,
        // во избежании дальнейших ошибок
        this.father = nullFather;
        this.mother = nullMother;
        children = new ArrayList<>();
    }

    // Конструктор для женского пола
    public Person(String name, boolean isFemale) {
        this(name);
        this.isFemale = isFemale;
    }

    public Integer childrenAmount() {
        return this.children.size();
    }

    @Override
    public String toString() {
//        String married = isFemale ? "замужем за " : "женат на ";
        String result;
//        result = name + "\n" + (isMarried ? married + partner.name : "холост") + "\n"
//                + childrenAmount() + " детей";
        result = name;
        return result;
    }

    static Person nullFather = new Person("неизвестен");
    static Person nullMother = new Person("неизвестна", true);

}
