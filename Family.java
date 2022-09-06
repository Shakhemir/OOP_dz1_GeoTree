package DZ_OOP_01_geo_tree;

import java.util.Arrays;
import java.util.List;

public class Family {

    static void marry(Person partner1, Person partner2) {
        checkSex(partner1, partner2);  // Проверка на разнополость партнеров
        // Церемония бракосочетания
        partner1.isMarried = true;
        partner2.isMarried = true;
        partner1.partner = partner2;
        partner2.partner = partner1;
    }

    // Добавление детей одной персоне
    static void addChildren(Person person, List<Person> children) {
        person.children.addAll(children);
        for (Person child : children) {
            if (!person.isFemale) {
                child.father = person;
            } else {
                child.mother = person;
            }
        }
    }

    // Добавление общих детей двоим персонам
    static void addChildren(Person father, Person mother, List<Person> children) {
        checkSex(father, mother);
        addChildren(father, children);
        addChildren(mother, children);
    }

    static void setParents(Person person, Person father, Person mother) {
        checkSex(father, mother);
        person.father = father;
        person.mother = mother;
        addChildren(father, Arrays.asList(person));
        addChildren(mother, Arrays.asList(person));
    }

    static void setParent(Person person, Person parent) {
        if (parent.isFemale) {
            setParents(person, Person.nullFather, parent);
        } else {
            setParents(person, parent, Person.nullMother);
        }
    }
    private static void checkSex(Person partner1, Person partner2) {
        // Проверка на разнополость партнеров
        if (partner1.isFemale == partner2.isFemale) {
            throw new IllegalArgumentException("Однополые браки запрещены!");
        }
    }


}
