package Main.repository;

import Main.object.Person;
import Main.object.Role;

public class PersonRepository {

    private RepositoryService<Person> personRepositoryService;

    private int CAPACITY = 10;

    private Person[] personArrays = new Person[CAPACITY];
    private Iterable<? extends Person> persons;

    public PersonRepository() {
        personRepositoryService = new RepositoryService<>();
    }

    public Person[] getPersonArrays() {
        return personArrays;
    }

    public void addPerson(Person person) {
        personRepositoryService.add(person);
    }

    public void remove(int index) {
        personRepositoryService.remove(index);
    }

    public Iterable<? extends Person> getPersons() {
        return persons;
    }

    public void setPersons(Iterable<? extends Person> persons) {
        this.persons = persons;
    }


}
