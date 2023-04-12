package Main.repository;

import Main.object.Person;

public interface PersonInterface {
    void addPerson(Person person);
    void remove(int index);
    Iterable<? extends Person> getPersons();
    void setPersons(Iterable<? extends Person> persons);
}