package DZ_OOP_01_geo_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * В этом классе реализованы методы для исследования различных семейных отношений
 * таких как: отец, мать, братья, сестры, теща, тесть, свекр, свекровь, дедушки, бабушки и т.д.
 */
public class Research {

    // Отдельно по отцу и матери
    static Person father(Person person) {
        return person.father;
    }

    static Person mother(Person person) {
        return person.mother;
    }

    // Либо обоих родителей списком
    static ArrayList<Person> parents(Person person) {
        return new ArrayList<>(Arrays.asList(person.father, person.mother));
    }

    // Список детей
    static List<Person> children(Person person) {
        return person.children;
    }

    // Братья с учетом сводных
    static List<Person> brothers(Person person) {
        List<Person> result = brothersByFather(person);
        List<Person> byMother = brothersByMother(person);
        for (Person br : byMother) {
            if (!result.contains(br)) {
                result.add(br);
            }
        }
        if (result.contains(person)) {
            result.remove(person);
        }
        return result;
    }

    // Сестры с учетом сводных
    static List<Person> sisters(Person person) {
        List<Person> result = sistersByFather(person);
        List<Person> byMother = sistersByMother(person);
        for (Person br : byMother) {
            if (!result.contains(br)) {
                result.add(br);
            }
        }
        if (result.contains(person)) {
            result.remove(person);
        }
        return result;
    }

    // Список дедушек и бабушек сначала по отцу, затем по матери
    static List<Person> grandParents(Person person) {
        List<Person> result = new ArrayList<>();
        for (Person p : parents(person)) {
            result.addAll(parents(p));
        }
        return result;
    }

    // Список всех внуков и внучек
    static List<Person> grandСhildren(Person person) {
        List<Person> result = new ArrayList<>();
        for (Person p : person.children) {
            result.addAll(p.children);
        }
        return result;
    }

    // Тесть и теща, либо свекр и свекровь
    static List<Person> parentsInLaw(Person person) {
        if (person.isMarried) {
            return parents(person.partner);
        }
        return null;
    }

    // Далее реализованы списки братье и сестер отдельно по отцу и по матери
    static List<Person> brothersByFather(Person person) {
        return brothersOrSistersByParent(person.father, false);
    }

    static List<Person> brothersByMother(Person person) {
        return brothersOrSistersByParent(person.mother, false);
    }

    static List<Person> sistersByFather(Person person) {
        return brothersOrSistersByParent(person.father, true);
    }

    static List<Person> sistersByMother(Person person) {
        return brothersOrSistersByParent(person.mother, true);
    }

    // Скрытый метод реализующий общий поиск братьев либо сестер, по отцу либо по матери
    private static List<Person> brothersOrSistersByParent(Person parent, boolean isSister) {
        List<Person> result = new ArrayList<>();
        for (Person broSis : parent.children) {
            if (broSis.isFemale == isSister) {
                result.add(broSis);
            }
        }
        return result;
    }

}
