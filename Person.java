package DZ_OOP_01_geo_tree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    public String name;
    public boolean isFemale;  // false - мужской пол, true - женский пол
    public boolean isMarried;  // статус брака
    public Person partner;  // муж / жена
    public List<Person> children;  // дети (список)

    public Person(String name) {
        this.name = name;
        this.isMarried = false;
        this.isFemale = false;
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
        String married = isFemale ? "замужем за " : "женат на ";
        return name + ", " + (isMarried ? married + partner.name : "холост") + ", "
                + childrenAmount() + " детей";
    }
}
