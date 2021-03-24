package seedu.address.model.person.comparator;

import java.util.Comparator;

import seedu.address.model.person.Person;

public class PhoneComparator implements Comparator<Person> {

    @Override
    public int compare(Person firstPerson, Person secondPerson) {
        return firstPerson.getPhone().compareTo(secondPerson.getPhone());
    }
}
