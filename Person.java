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

    public Person(String name, boolean isFemale) {
        this(name);
        this.isFemale = isFemale;
    }

    public void setPartner(Person partner) {
        // Проверка на разнополость партнеров
        if (this.isFemale == partner.isFemale) {
            throw new IllegalArgumentException("Однополые браки запрещены!");
        }
        // Церемония бракосочетания
        this.isMarried = true;
        partner.isMarried = true;
        this.partner = partner;
        partner.partner = this;
    }

    public void addChildren(List<Person> children) {
        this.children.addAll(children);
    }

    public Integer childrenAmount() {
        return this.children.size();
    }
}
